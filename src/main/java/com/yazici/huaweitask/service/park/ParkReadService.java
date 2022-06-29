package com.yazici.huaweitask.service.park;

import com.yazici.huaweitask.constant.ParkError;
import com.yazici.huaweitask.entity.Park;
import com.yazici.huaweitask.entity.ParkingArea;
import com.yazici.huaweitask.entity.Vehicle;
import com.yazici.huaweitask.entity.enums.ParkStatus;
import com.yazici.huaweitask.exception.ParkException;
import com.yazici.huaweitask.repository.ParkRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ParkReadService {

  private final ParkRepository parkRepository;

  @Transactional(readOnly = true)
  public List<Park> findDoneParksWithDate(ParkingArea parkingArea, LocalDate date) {

    var start = date.atStartOfDay();
    var end = start.plusDays(1);
    return parkRepository.findParkByParkingAreaAndStatusAndCheckOutDateBetween(
        parkingArea, ParkStatus.DONE, start, end);
  }

  @Transactional(readOnly = true)
  public Integer countCurrentParks(ParkingArea parkingArea) {
    return parkRepository.countByParkingAreaAndStatus(parkingArea, ParkStatus.IN_PROGRESS);
  }

  @Transactional(readOnly = true)
  public Park findByVehicleAndStatus(Vehicle vehicle, ParkStatus status) {
    return parkRepository
        .findByVehicleAndStatus(vehicle, status)
        .orElseThrow(() -> new ParkException(ParkError.NOT_FOUND));
  }
}
