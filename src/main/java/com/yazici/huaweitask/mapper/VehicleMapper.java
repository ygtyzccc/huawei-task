package com.yazici.huaweitask.mapper;

import com.yazici.huaweitask.dto.request.VehicleCheckInRequest;
import com.yazici.huaweitask.dto.response.VehicleCheckInResponse;
import com.yazici.huaweitask.entity.Vehicle;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VehicleMapper {

  Vehicle map(VehicleCheckInRequest vehicleCheckInRequest);

  VehicleCheckInResponse mapToCheckInResponse(Vehicle vehicle);
}
