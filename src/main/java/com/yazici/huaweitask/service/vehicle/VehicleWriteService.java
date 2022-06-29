package com.yazici.huaweitask.service.vehicle;

import com.yazici.huaweitask.entity.Vehicle;
import com.yazici.huaweitask.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class VehicleWriteService {

  private final VehicleRepository vehicleRepository;

  @Transactional
  public Vehicle save(Vehicle vehicle) {
    return vehicleRepository.save(vehicle);
  }
}
