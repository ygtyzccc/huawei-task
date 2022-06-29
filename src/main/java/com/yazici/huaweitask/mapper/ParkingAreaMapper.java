package com.yazici.huaweitask.mapper;

import com.yazici.huaweitask.dto.request.ParkingAreaCreateRequest;
import com.yazici.huaweitask.dto.response.ParkingAreaCreateResponse;
import com.yazici.huaweitask.dto.response.ParkingAreaQueryResponse;
import com.yazici.huaweitask.entity.ParkingArea;
import org.mapstruct.Mapper;

@Mapper(
    componentModel = "spring",
    uses = {PriceListMapper.class})
public interface ParkingAreaMapper {

  ParkingArea map(ParkingAreaCreateRequest parkingAreaCreateRequest);

  ParkingAreaCreateResponse mapToCreateResponse(ParkingArea parkingArea);

  ParkingAreaQueryResponse mapToQueryResponse(ParkingArea parkArea);
}
