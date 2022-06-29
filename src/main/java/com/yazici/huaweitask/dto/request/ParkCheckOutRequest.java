package com.yazici.huaweitask.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParkCheckOutRequest {

  @NotNull(message = "Parking area id must be required")
  private Long parkingAreaId;

  @NotNull(message = "Check-out date must be required")
  private LocalDateTime checkOutDate;

  @NotNull(message = "Vehicle must be required")
  @Valid
  private VehicleCheckOutRequest vehicle;
}
