package com.yazici.huaweitask.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParkingAreaCreateResponse {

  private Long id;
  private Date createDate;
  private String name;
  private Integer capacity;
  private String city;
  private List<PriceListCreateResponse> priceLists;
}
