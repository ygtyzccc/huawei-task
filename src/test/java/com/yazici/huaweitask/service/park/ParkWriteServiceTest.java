package com.yazici.huaweitask.service.park;

import com.yazici.huaweitask.entity.Park;
import com.yazici.huaweitask.repository.ParkRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ParkWriteServiceTest {

    @InjectMocks private ParkWriteService parkWriteService;
    @Mock private ParkRepository parkRepository;

    @Test
    void shouldSave() {
        //given
        var park = new Park();
        //when
        parkWriteService.save(park);
        //then
        ArgumentCaptor<Park> parkArgumentCaptor = ArgumentCaptor.forClass(Park.class);

        verify(parkRepository).save(parkArgumentCaptor.capture());
        assertThat(parkArgumentCaptor.getValue()).isEqualTo(park);
    }
}