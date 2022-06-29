package com.yazici.huaweitask.repository;

import com.yazici.huaweitask.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

  Optional<Vehicle> findByLicensePlate(String licensePlate);
}
