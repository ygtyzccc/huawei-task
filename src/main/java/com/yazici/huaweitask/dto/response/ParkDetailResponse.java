package com.yazici.huaweitask.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParkDetailResponse {

  private String parkingAreaName;
  private LocalDateTime checkInDate;
  private LocalDateTime checkOutDate;
  private Double fee;
}
