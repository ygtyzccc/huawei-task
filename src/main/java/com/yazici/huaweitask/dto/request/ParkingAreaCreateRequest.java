package com.yazici.huaweitask.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParkingAreaCreateRequest {

  @NotEmpty(message = "Parking area's name must be required")
  private String name;

  @Min(value = 1, message = "Parking are capacity must be greater than 0")
  private Long capacity;

  @NotEmpty(message = "Parking area's city must be required")
  private String city;

  @NotEmpty @Valid private List<PriceListCreateRequest> priceLists;
}
