package com.yazici.huaweitask.service.parkingarea;

import com.yazici.huaweitask.constant.ParkingAreaError;
import com.yazici.huaweitask.dto.request.ParkingAreaCreateRequest;
import com.yazici.huaweitask.dto.request.ParkingAreaUpdateRequest;
import com.yazici.huaweitask.dto.response.ParkingAreaCreateResponse;
import com.yazici.huaweitask.dto.response.ParkingAreaIncomeResponse;
import com.yazici.huaweitask.dto.response.ParkingAreaQueryResponse;
import com.yazici.huaweitask.entity.Park;
import com.yazici.huaweitask.exception.ParkingAreaException;
import com.yazici.huaweitask.mapper.ParkingAreaMapper;
import com.yazici.huaweitask.service.park.ParkReadService;
import com.yazici.huaweitask.service.pricelist.PriceListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ParkingAreaService {

  private final ParkingAreaMapper parkingAreaMapper;
  private final ParkingAreaReadService parkingAreaReadService;
  private final ParkingAreaWriteService parkingAreaWriteService;
  private final ParkingAreaUpdateService parkingAreaUpdateService;
  private final ParkingAreaDeleteService parkingAreaDeleteService;

  private final PriceListService priceListService;
  private final ParkReadService parkReadService;

  @Transactional
  public ParkingAreaCreateResponse create(ParkingAreaCreateRequest requestBody) {

    if (parkingAreaReadService.existsByName(requestBody.getName())) {
      throw new ParkingAreaException(ParkingAreaError.CONFLICT);
    }

    var parkArea = parkingAreaMapper.map(requestBody);
    var savedParkArea = parkingAreaWriteService.save(parkArea);

    var priceLists = priceListService.create(parkArea, requestBody.getPriceLists());
    savedParkArea.setPriceLists(priceLists);
    return parkingAreaMapper.mapToCreateResponse(parkArea);
  }

  @Transactional
  public void update(Long id, ParkingAreaUpdateRequest requestBody) {
    var parkingArea = parkingAreaReadService.findById(id);
    parkingAreaUpdateService.update(parkingArea, requestBody);
  }

  @Transactional
  public void delete(Long id) {
    var parkArea = parkingAreaReadService.findById(id);
    parkingAreaDeleteService.delete(parkArea);
  }

  @Transactional(readOnly = true)
  public ParkingAreaQueryResponse get(String name) {
    var parkArea = parkingAreaReadService.findByName(name);
    return parkingAreaMapper.mapToQueryResponse(parkArea);
  }

  @Transactional(readOnly = true)
  public ParkingAreaIncomeResponse getDailyIncome(String name, LocalDate date) {
    var parkingArea = parkingAreaReadService.findByName(name);
    var parks = parkReadService.findDoneParksWithDate(parkingArea, date);
    var income = parks.stream().mapToDouble(Park::getFee).sum();
    return ParkingAreaIncomeResponse.builder().income(income).name(parkingArea.getName()).build();
  }
}
