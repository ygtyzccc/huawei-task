package com.yazici.huaweitask.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParkCheckInRequest {

  @NotNull(message = "Parking area id must be required")
  private Long parkingAreaId;

  @NotNull(message = "Check-in date must be required")
  private Date checkInDate;

  @NotNull(message = "Vehicle must be required")
  @Valid
  private VehicleCheckInRequest vehicle;
}
