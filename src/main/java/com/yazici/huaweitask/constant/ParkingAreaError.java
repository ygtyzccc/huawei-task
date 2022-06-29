package com.yazici.huaweitask.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ParkingAreaError {
  NOT_FOUND(1000, HttpStatus.NOT_FOUND, "Parking area not found"),
  CONFLICT(1001, HttpStatus.CONFLICT, "Parking area is already exist"),

  INVALID_CAPACITY(1002, HttpStatus.BAD_REQUEST, "Parking area capacity is not enough");

  private final Integer errorCode;
  private final HttpStatus httpStatus;
  private final String message;
}
