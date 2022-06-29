package com.yazici.huaweitask.repository;

import com.yazici.huaweitask.entity.Park;
import com.yazici.huaweitask.entity.ParkingArea;
import com.yazici.huaweitask.entity.Vehicle;
import com.yazici.huaweitask.entity.enums.ParkStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ParkRepository extends JpaRepository<Park, Long> {

  List<Park>  findParkByParkingAreaAndStatusAndCheckOutDateBetween(
      ParkingArea parkingArea, ParkStatus status, LocalDateTime start, LocalDateTime end);

  Integer countByParkingAreaAndStatus(ParkingArea parkingArea, ParkStatus parkStatus);

  Optional<Park> findByVehicleAndStatus(Vehicle vehicle, ParkStatus parkStatus);
}
