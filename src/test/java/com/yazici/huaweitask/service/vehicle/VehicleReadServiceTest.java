package com.yazici.huaweitask.service.vehicle;

import com.yazici.huaweitask.entity.Vehicle;
import com.yazici.huaweitask.exception.VehicleException;
import com.yazici.huaweitask.repository.VehicleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VehicleReadServiceTest {

    @InjectMocks private VehicleReadService vehicleReadService;
    @Mock private VehicleRepository vehicleRepository;

    @Test
    void shouldFindByLicensePlate() {
        //given
        var plate = "34YY6741";
        var vehicle = new Vehicle();
        //when
        when(vehicleRepository.findByLicensePlate(anyString()))
                .thenReturn(Optional.of(vehicle));
        var result = vehicleReadService.findByLicensePlate(plate);
        //then
        verify(vehicleRepository, times(1))
                .findByLicensePlate(plate);

        assertEquals(vehicle, result);
    }

    @Test
    void findOptionalByLicensePlate() {
        //given
        var plate = "34YY6741";
        var vehicle = new Vehicle();
        var vehicleOpt = Optional.of(vehicle);
        //when
        when(vehicleRepository.findByLicensePlate(anyString()))
                .thenReturn(Optional.of(vehicle));
        var resultOpt = vehicleReadService.findOptionalByLicensePlate(plate);
        //then
        verify(vehicleRepository, times(1))
                .findByLicensePlate(plate);

        assertEquals(resultOpt, vehicleOpt);
    }

    @Test
    void shouldThrowExceptionFindByLicensePlate(){
        //given
        var plate = "plate";

        assertThrows(VehicleException.class, () -> vehicleReadService.findByLicensePlate(plate));
        //verify
        verify(vehicleRepository, times(1))
                .findByLicensePlate(plate);
    }
}