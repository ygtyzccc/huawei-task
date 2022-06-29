package com.yazici.huaweitask.exception;

import com.yazici.huaweitask.constant.ParkError;
import lombok.Getter;

@Getter
public class ParkException extends RuntimeException {

  private final ParkError parkError;

  public ParkException(ParkError parkError) {
    super(parkError.getMessage());
    this.parkError = parkError;
  }
}
