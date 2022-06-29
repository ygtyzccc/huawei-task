package com.yazici.huaweitask.controller;

import com.yazici.huaweitask.dto.response.VehicleParkingDetailResponse;
import com.yazici.huaweitask.service.vehicle.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(VehicleController.ENDPOINT)
@RequiredArgsConstructor
public class VehicleController {

  public static final String ENDPOINT = "vehicle";

  private final VehicleService vehicleService;

  @GetMapping
  public VehicleParkingDetailResponse getParkingDetails(@RequestParam String licensePlate) {
    return vehicleService.getParkingDetail(licensePlate);
  }
}
