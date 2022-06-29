package com.yazici.huaweitask.dto.request;

import com.yazici.huaweitask.entity.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleCheckInRequest {

  @NotEmpty(message = "License plate must be required")
  private String licensePlate;

  @NotNull(message = "Vehicle type must be required")
  private VehicleType type;
}
