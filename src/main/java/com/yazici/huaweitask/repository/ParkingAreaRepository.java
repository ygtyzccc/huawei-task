package com.yazici.huaweitask.repository;

import com.yazici.huaweitask.entity.ParkingArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParkingAreaRepository extends JpaRepository<ParkingArea, Long> {

  boolean existsByName(String name);

  Optional<ParkingArea> findByName(String name);
}
