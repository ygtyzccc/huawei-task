package com.yazici.huaweitask.service.parkingarea;

import com.yazici.huaweitask.entity.ParkingArea;
import com.yazici.huaweitask.repository.ParkingAreaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ParkingAreaWriteService {

  private final ParkingAreaRepository parkingAreaRepository;

  @Transactional
  public ParkingArea save(ParkingArea parkingArea) {
    return parkingAreaRepository.save(parkingArea);
  }
}
