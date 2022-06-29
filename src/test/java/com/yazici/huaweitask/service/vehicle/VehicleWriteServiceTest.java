package com.yazici.huaweitask.service.vehicle;

import com.yazici.huaweitask.entity.Vehicle;
import com.yazici.huaweitask.repository.VehicleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class VehicleWriteServiceTest {

    @InjectMocks private VehicleWriteService vehicleWriteService;
    @Mock private VehicleRepository vehicleRepository;

    @Test
    void shouldSave() {
        //given
        var vehicle = new Vehicle();
        //when
        vehicleWriteService.save(vehicle);
        //then
        ArgumentCaptor<Vehicle> parkingAreaArgumentCaptor = ArgumentCaptor.forClass(Vehicle.class);

        verify(vehicleRepository).save(parkingAreaArgumentCaptor.capture());
        assertThat(parkingAreaArgumentCaptor.getValue()).isEqualTo(vehicle);
    }
}