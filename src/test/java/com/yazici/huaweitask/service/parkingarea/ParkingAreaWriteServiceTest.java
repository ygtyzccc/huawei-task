package com.yazici.huaweitask.service.parkingarea;

import com.yazici.huaweitask.entity.ParkingArea;
import com.yazici.huaweitask.repository.ParkingAreaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ParkingAreaWriteServiceTest {
    @InjectMocks private ParkingAreaWriteService parkingAreaWriteService;
    @Mock private ParkingAreaRepository parkingAreaRepository;

    @Test
    void shouldSave() {
        //given
        var parkingArea = new ParkingArea();
        //when
        parkingAreaWriteService.save(parkingArea);
        //then
        ArgumentCaptor<ParkingArea> parkingAreaArgumentCaptor = ArgumentCaptor.forClass(ParkingArea.class);

        verify(parkingAreaRepository).save(parkingAreaArgumentCaptor.capture());
        assertThat(parkingAreaArgumentCaptor.getValue()).isEqualTo(parkingArea);
    }

}