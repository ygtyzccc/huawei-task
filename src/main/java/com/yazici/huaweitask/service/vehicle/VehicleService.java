package com.yazici.huaweitask.service.vehicle;

import com.yazici.huaweitask.dto.request.VehicleCheckInRequest;
import com.yazici.huaweitask.dto.response.ParkDetailResponse;
import com.yazici.huaweitask.dto.response.VehicleParkingDetailResponse;
import com.yazici.huaweitask.entity.Vehicle;
import com.yazici.huaweitask.mapper.VehicleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VehicleService {

  private final VehicleMapper vehicleMapper;
  private final VehicleReadService vehicleReadService;
  private final VehicleWriteService vehicleWriteService;

  @Transactional
  public Vehicle createOrGet(VehicleCheckInRequest vehicleCheckInRequest) {
    var vehicle =
        vehicleReadService.findOptionalByLicensePlate(vehicleCheckInRequest.getLicensePlate());
    return vehicle.orElseGet(() -> create(vehicleCheckInRequest));
  }

  private Vehicle create(VehicleCheckInRequest vehicleCheckInRequest) {
    var vehicle = vehicleMapper.map(vehicleCheckInRequest);
    return vehicleWriteService.save(vehicle);
  }

  @Transactional(readOnly = true)
  public Vehicle findByLicensePlate(String licensePlate) {
    return vehicleReadService.findByLicensePlate(licensePlate);
  }

  @Transactional(readOnly = true)
  public VehicleParkingDetailResponse getParkingDetail(String licensePlate) {
    var vehicle = vehicleReadService.findByLicensePlate(licensePlate);

    var parkHistory =
        vehicle.getParks().stream()
            .map(
                park -> {
                  var parkingArea = park.getParkingArea();
                  return ParkDetailResponse.builder()
                      .checkInDate(park.getCheckInDate())
                      .checkOutDate(park.getCheckOutDate())
                      .fee(park.getFee())
                      .parkingAreaName(parkingArea.getName())
                      .build();
                })
            .collect(Collectors.toList());

    return VehicleParkingDetailResponse.builder()
        .licensePlate(vehicle.getLicensePlate())
        .parkHistory(parkHistory)
        .build();
  }
}
