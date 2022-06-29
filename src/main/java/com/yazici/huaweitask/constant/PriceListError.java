package com.yazici.huaweitask.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum PriceListError {
  NOT_FOUND(2000, HttpStatus.NOT_FOUND, "Price list not found"),
  INVALID_START_END_HOUR(2001, HttpStatus.BAD_REQUEST, "Start hour and end hour are invalid"),
  INVALID_HOUR_COVERAGE(2002, HttpStatus.BAD_REQUEST, "Price list is not covering 24 hours"),
  INVALID_HOUR_RANGE(2003, HttpStatus.NOT_FOUND, "Price list is not found within giving range ");

  private final Integer errorCode;
  private final HttpStatus httpStatus;
  private final String message;
}
