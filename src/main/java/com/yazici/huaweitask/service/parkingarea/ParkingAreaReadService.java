package com.yazici.huaweitask.service.parkingarea;

import com.yazici.huaweitask.constant.ParkingAreaError;
import com.yazici.huaweitask.entity.ParkingArea;
import com.yazici.huaweitask.exception.ParkingAreaException;
import com.yazici.huaweitask.repository.ParkingAreaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ParkingAreaReadService {

  private final ParkingAreaRepository parkingAreaRepository;

  @Transactional(readOnly = true)
  public boolean existsByName(String name) {
    return parkingAreaRepository.existsByName(name);
  }

  @Transactional(readOnly = true)
  public ParkingArea findById(Long id) {
    return parkingAreaRepository
        .findById(id)
        .orElseThrow(() -> new ParkingAreaException(ParkingAreaError.NOT_FOUND));
  }

  @Transactional(readOnly = true)
  public ParkingArea findByName(String name) {
    return parkingAreaRepository
        .findByName(name)
        .orElseThrow(() -> new ParkingAreaException(ParkingAreaError.NOT_FOUND));
  }
}
