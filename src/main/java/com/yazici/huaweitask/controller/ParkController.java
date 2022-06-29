package com.yazici.huaweitask.controller;

import com.yazici.huaweitask.dto.request.ParkCheckInRequest;
import com.yazici.huaweitask.dto.request.ParkCheckOutRequest;
import com.yazici.huaweitask.dto.response.ParkCheckInResponse;
import com.yazici.huaweitask.dto.response.ParkCheckOutResponse;
import com.yazici.huaweitask.service.park.ParkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(ParkController.ENDPOINT)
@RequiredArgsConstructor
public class ParkController {

  public static final String ENDPOINT = "park";

  private final ParkService parkService;

  @PostMapping("check-in")
  public ParkCheckInResponse checkIn(@RequestBody @Valid ParkCheckInRequest requestBody) {
    return parkService.checkIn(requestBody);
  }

  @PostMapping("check-out")
  public ParkCheckOutResponse checkOut(@RequestBody @Valid ParkCheckOutRequest requestBody) {
    return parkService.checkOut(requestBody);
  }
}
