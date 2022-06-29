package com.yazici.huaweitask.service.parkingarea;

import com.yazici.huaweitask.dto.request.ParkingAreaCreateRequest;
import com.yazici.huaweitask.dto.response.ParkingAreaCreateResponse;
import com.yazici.huaweitask.entity.ParkingArea;
import com.yazici.huaweitask.entity.PriceList;
import com.yazici.huaweitask.exception.ParkingAreaException;
import com.yazici.huaweitask.mapper.ParkingAreaMapper;
import com.yazici.huaweitask.service.park.ParkReadService;
import com.yazici.huaweitask.service.pricelist.PriceListService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ParkingAreaServiceTest {

    @Mock private  ParkingAreaMapper parkingAreaMapper;
    @Mock private  ParkingAreaReadService parkingAreaReadService;
    @Mock private  ParkingAreaWriteService parkingAreaWriteService;
    @Mock private  PriceListService priceListService;

    @InjectMocks private ParkingAreaService parkingAreaService;

    @Test
    void shouldCreate() {
        //given
        var request = new ParkingAreaCreateRequest();
        var response = new ParkingAreaCreateResponse();
        request.setName("name");
        request.setPriceLists(new ArrayList<>());
        var parkArea = new ParkingArea();
        var priceLists = new ArrayList<PriceList>();
        //when
        when(parkingAreaReadService.existsByName(anyString())).thenReturn(false);
        when(parkingAreaMapper.map(any())).thenReturn(parkArea);
        when(parkingAreaWriteService.save(any())).thenReturn(parkArea);
        when(priceListService.create(any(), anyList())).thenReturn(priceLists);
        when(parkingAreaMapper.mapToCreateResponse(any())).thenReturn(response);

        var result = parkingAreaService.create(request);

        //verify
        verify(parkingAreaReadService).existsByName(request.getName());
        verify(parkingAreaMapper).map(request);
        verify(parkingAreaWriteService).save(parkArea);
        verify(priceListService).create(parkArea , request.getPriceLists());
        verify(parkingAreaMapper).mapToCreateResponse(parkArea);


        assertEquals(result, response);
    }

    @Test
    void shouldNotCreateAndThrowException(){
        // given
        var request = new ParkingAreaCreateRequest();
        request.setName("name");
        //when
        when(parkingAreaReadService.existsByName(request.getName())).thenReturn(true);

        //verify
        assertThrows(ParkingAreaException.class , () -> parkingAreaService.create(request));

    }
}