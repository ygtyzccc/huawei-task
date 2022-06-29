package com.yazici.huaweitask.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PriceListCreateRequest {

  @Min(value = 0, message = "Price list's start hour must be greater than or equal to 0")
  private Integer startHour;

  @Max(value = 24, message = "Price list's end hour must be lower than or equal to 24")
  private Integer endHour;

  private Long price;
}
