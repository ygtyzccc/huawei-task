package com.yazici.huaweitask.exception;

import com.yazici.huaweitask.constant.VehicleError;
import lombok.Getter;

@Getter
public class VehicleException extends RuntimeException {

  private final VehicleError vehicleError;

  public VehicleException(VehicleError vehicleError) {
    super(vehicleError.getMessage());
    this.vehicleError = vehicleError;
  }
}
