package com.yazici.huaweitask.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum VehicleError {
  NOT_FOUND(3000, HttpStatus.NOT_FOUND, "Vehicle not found");

  private final Integer errorCode;
  private final HttpStatus httpStatus;
  private final String message;
}
