package com.yazici.huaweitask.mapper;

import com.yazici.huaweitask.dto.request.ParkCheckInRequest;
import com.yazici.huaweitask.dto.response.ParkCheckInResponse;
import com.yazici.huaweitask.entity.Park;
import org.mapstruct.Mapper;

@Mapper(
    componentModel = "spring",
    uses = {VehicleMapper.class})
public interface ParkMapper {
  Park map(ParkCheckInRequest requestBody);

  ParkCheckInResponse mapToCheckInResponse(Park park);
}
