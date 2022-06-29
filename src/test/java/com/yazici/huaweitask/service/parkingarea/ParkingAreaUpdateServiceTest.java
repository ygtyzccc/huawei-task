package com.yazici.huaweitask.service.parkingarea;

import com.yazici.huaweitask.dto.request.ParkingAreaUpdateRequest;
import com.yazici.huaweitask.entity.ParkingArea;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ParkingAreaUpdateServiceTest {

   @InjectMocks private ParkingAreaUpdateService parkingAreaUpdateService;
   @Mock private ParkingAreaWriteService parkingAreaWriteService;


    @Test
    void update() {

        //given
        var parkingArea = new ParkingArea();
        var parkingAreaUpdateRequest = new ParkingAreaUpdateRequest();

        //when
        parkingAreaUpdateService.update(parkingArea, parkingAreaUpdateRequest);
        //then
        ArgumentCaptor<ParkingArea> parkingAreaArgumentCaptor = ArgumentCaptor.forClass(ParkingArea.class);

        verify(parkingAreaWriteService).save(parkingAreaArgumentCaptor.capture());
        assertThat(parkingAreaArgumentCaptor.getValue()).isEqualTo(parkingArea);
    }
}