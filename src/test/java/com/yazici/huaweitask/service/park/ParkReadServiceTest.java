package com.yazici.huaweitask.service.park;

import com.yazici.huaweitask.entity.ParkingArea;
import com.yazici.huaweitask.entity.enums.ParkStatus;
import com.yazici.huaweitask.repository.ParkRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
 class ParkReadServiceTest {

  @InjectMocks private ParkReadService parkReadService;
  @Mock private ParkRepository parkRepository;

  @Test
  void shouldFindDoneParksWithDate() {
    // given
    var parkingArea = new ParkingArea();
    var date = LocalDate.now();
    // when

    parkReadService.findDoneParksWithDate(parkingArea, date);

    // verify
    verify(parkRepository)
        .findParkByParkingAreaAndStatusAndCheckOutDateBetween(
            parkingArea, ParkStatus.DONE, date.atStartOfDay(), date.atStartOfDay().plusDays(1));
  }

  @Test
  void shouldCountCurrentParks() {
    // given
    var parkingArea = new ParkingArea();
    var count = 10;
    // when
    when(parkRepository.countByParkingAreaAndStatus(any(), any())).thenReturn(count);

    var result = parkReadService.countCurrentParks(parkingArea);

    // verify
    assertEquals(count, result);
    verify(parkRepository).countByParkingAreaAndStatus(parkingArea, ParkStatus.IN_PROGRESS);
  }
}
