package com.yazici.huaweitask.service.vehicle;

import com.yazici.huaweitask.constant.VehicleError;
import com.yazici.huaweitask.entity.Vehicle;
import com.yazici.huaweitask.exception.VehicleException;
import com.yazici.huaweitask.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VehicleReadService {

  private final VehicleRepository vehicleRepository;

  @Transactional(readOnly = true)
  public Vehicle findByLicensePlate(String licensePlate) {
    return vehicleRepository
        .findByLicensePlate(licensePlate)
        .orElseThrow(() -> new VehicleException(VehicleError.NOT_FOUND));
  }

  @Transactional(readOnly = true)
  public Optional<Vehicle> findOptionalByLicensePlate(String licensePlate) {
    return vehicleRepository.findByLicensePlate(licensePlate);
  }
}
