package com.yazici.huaweitask.exception;

import com.yazici.huaweitask.constant.ParkingAreaError;
import lombok.Getter;

@Getter
public class ParkingAreaException extends RuntimeException {

  private final ParkingAreaError parkingAreaError;

  public ParkingAreaException(ParkingAreaError parkingAreaError) {
    super(parkingAreaError.getMessage());
    this.parkingAreaError = parkingAreaError;
  }
}
