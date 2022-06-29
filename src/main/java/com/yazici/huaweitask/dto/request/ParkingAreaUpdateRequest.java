package com.yazici.huaweitask.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParkingAreaUpdateRequest {

  private String name;
  private Integer capacity;
  private String city;
}
