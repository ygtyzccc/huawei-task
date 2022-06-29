package com.yazici.huaweitask.service.parkingarea;

import com.yazici.huaweitask.dto.request.ParkingAreaUpdateRequest;
import com.yazici.huaweitask.entity.ParkingArea;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.yazici.huaweitask.utils.StreamUtils.setIfNotNull;

@Service
@RequiredArgsConstructor
public class ParkingAreaUpdateService {

  private final ParkingAreaWriteService parkingAreaWriteService;

  @Transactional
  public ParkingArea update(ParkingArea parkingArea, ParkingAreaUpdateRequest updateRequest) {
    setIfNotNull(updateRequest.getName(), parkingArea::setName);
    setIfNotNull(updateRequest.getCapacity(), parkingArea::setCapacity);
    setIfNotNull(updateRequest.getCity(), parkingArea::setCity);
    return parkingAreaWriteService.save(parkingArea);
  }
}
