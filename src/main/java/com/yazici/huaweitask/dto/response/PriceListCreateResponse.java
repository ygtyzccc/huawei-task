package com.yazici.huaweitask.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PriceListCreateResponse {

  private Long id;
  private Integer startHour;
  private Integer endHour;
  private Long price;
}
