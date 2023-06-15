package com.transportation.city.service;

import com.transportation.city.converter.StopConverter;
import com.transportation.city.converter.StopDtoConverter;
import com.transportation.city.model.Stop;
import com.transportation.city.repository.StopRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.HashSet;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StopServiceTest {

    private StopRepository stopRepository;

    private StopService stopService;

    private StopDtoConverter stopDtoConverter;

    private StopConverter stopConverter;

    @BeforeEach
    public void setUp(){
        stopRepository= Mockito.mock(StopRepository.class);
        stopDtoConverter = Mockito.mock(StopDtoConverter.class);
        stopConverter = Mockito.mock(StopConverter.class);
        stopService = new StopService(stopRepository,stopConverter,stopDtoConverter);
    }

    @Test
    public void testFindByStopId_whenStopIdExist_shouldReturnStop(){
        Stop stop = new Stop("id","kızlarpınarı",new HashSet<>());
        Mockito.when(stopRepository.findById("id")).thenReturn(Optional.of(stop));

        Stop result = stopService.findByStopId("id");
        assertEquals(result,stop);
    }
}