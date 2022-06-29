package com.yazici.huaweitask.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleCheckOutResponse {
  private Long id;
  private String licensePlate;
  private Double fee;
}
