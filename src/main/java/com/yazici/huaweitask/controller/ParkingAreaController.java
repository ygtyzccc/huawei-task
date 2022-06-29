package com.yazici.huaweitask.controller;

import com.yazici.huaweitask.dto.request.ParkingAreaCreateRequest;
import com.yazici.huaweitask.dto.request.ParkingAreaUpdateRequest;
import com.yazici.huaweitask.dto.response.ParkingAreaCreateResponse;
import com.yazici.huaweitask.dto.response.ParkingAreaIncomeResponse;
import com.yazici.huaweitask.dto.response.ParkingAreaQueryResponse;
import com.yazici.huaweitask.service.parkingarea.ParkingAreaService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDate;

@RestController
@RequestMapping(ParkingAreaController.ENDPOINT)
@RequiredArgsConstructor
public class ParkingAreaController {

  public static final String ENDPOINT = "parking-area";

  private final ParkingAreaService parkingAreaService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public ParkingAreaCreateResponse create(
      @RequestBody @Valid ParkingAreaCreateRequest requestBody) {
    return parkingAreaService.create(requestBody);
  }

  @PutMapping("{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void update(
      @PathVariable Long id, @RequestBody @Valid ParkingAreaUpdateRequest requestBody) {
    parkingAreaService.update(id, requestBody);
  }

  @DeleteMapping("{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Long id) {
    parkingAreaService.delete(id);
  }

  @GetMapping
  public ParkingAreaQueryResponse get(@RequestParam String name) {
    return parkingAreaService.get(name);
  }

  @GetMapping("income")
  public ParkingAreaIncomeResponse getDailyIncome(
      @RequestParam String name,
      @RequestParam @DateTimeFormat(pattern = "dd.MM.yyyy") LocalDate date) {
    return parkingAreaService.getDailyIncome(name, date);
  }
}
