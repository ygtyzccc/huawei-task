package com.yazici.huaweitask.validation;

import com.yazici.huaweitask.constant.ParkingAreaError;
import com.yazici.huaweitask.entity.ParkingArea;
import com.yazici.huaweitask.exception.ParkingAreaException;
import com.yazici.huaweitask.service.park.ParkReadService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
@RequiredArgsConstructor
public class ParkingAreaValidator {

  private final ParkReadService parkReadService;

  @Transactional(readOnly = true)
  public void validateAvailableCapacity(ParkingArea parkingArea) {
    var currentParks = parkReadService.countCurrentParks(parkingArea);
    if (parkingArea.getCapacity() <= currentParks) {
      throw new ParkingAreaException(ParkingAreaError.INVALID_CAPACITY);
    }
  }
}
