package com.yazici.huaweitask.dto.response;

import com.yazici.huaweitask.entity.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleCheckInResponse {
  private Long id;
  private String licensePlate;
  private VehicleType type;
}
