package com.yazici.huaweitask.service.park;

import com.yazici.huaweitask.dto.request.ParkCheckInRequest;
import com.yazici.huaweitask.dto.request.ParkCheckOutRequest;
import com.yazici.huaweitask.dto.response.ParkCheckInResponse;
import com.yazici.huaweitask.dto.response.ParkCheckOutResponse;
import com.yazici.huaweitask.dto.response.VehicleCheckOutResponse;
import com.yazici.huaweitask.entity.Park;
import com.yazici.huaweitask.entity.ParkingArea;
import com.yazici.huaweitask.entity.Vehicle;
import com.yazici.huaweitask.entity.enums.ParkStatus;
import com.yazici.huaweitask.mapper.ParkMapper;
import com.yazici.huaweitask.service.parkingarea.ParkingAreaReadService;
import com.yazici.huaweitask.service.vehicle.VehicleService;
import com.yazici.huaweitask.strategy.FeeCalculationUtil;
import com.yazici.huaweitask.validation.ParkingAreaValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ParkService {

  private final ParkMapper parkMapper;
  private final VehicleService vehicleService;
  private final ParkingAreaReadService parkingAreaReadService;
  private final ParkingAreaValidator parkingAreaValidator;
  private final ParkWriteService parkWriteService;
  private final ParkReadService parkReadService;

  @Transactional
  public ParkCheckInResponse checkIn(ParkCheckInRequest requestBody) {
    var vehicle = vehicleService.createOrGet(requestBody.getVehicle());
    var parkingArea = parkingAreaReadService.findById(requestBody.getParkingAreaId());
    parkingAreaValidator.validateAvailableCapacity(parkingArea);
    var park = create(requestBody, vehicle, parkingArea);
    return parkMapper.mapToCheckInResponse(park);
  }

  @Transactional
  public ParkCheckOutResponse checkOut(ParkCheckOutRequest requestBody) {
    var vehicle = vehicleService.findByLicensePlate(requestBody.getVehicle().getLicensePlate());
    var park = parkReadService.findByVehicleAndStatus(vehicle, ParkStatus.IN_PROGRESS);
    park.setCheckOutDate(requestBody.getCheckOutDate());

    var priceLists = park.getParkingArea().getPriceLists();
    var fee = FeeCalculationUtil.calculate(priceLists, park);
    park.setStatus(ParkStatus.DONE);
    park.setFee(fee);
    park = parkWriteService.save(park);

    return ParkCheckOutResponse.builder()
        .id(park.getId())
        .vehicle(
            VehicleCheckOutResponse.builder()
                .id(vehicle.getId())
                .licensePlate(vehicle.getLicensePlate())
                .fee(fee)
                .build())
        .build();
  }

  private Park create(ParkCheckInRequest checkInRequest, Vehicle vehicle, ParkingArea parkingArea) {
    var park = parkMapper.map(checkInRequest);
    park.setVehicle(vehicle);
    park.setParkingArea(parkingArea);
    park.setStatus(ParkStatus.IN_PROGRESS);
    return parkWriteService.save(park);
  }
}
