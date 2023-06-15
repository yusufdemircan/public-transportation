package com.transportation.city.service;

import com.transportation.city.converter.*;
import com.transportation.city.model.Route;
import com.transportation.city.model.Schedule;
import com.transportation.city.model.Vehicle;
import com.transportation.city.repository.RouteRepository;
import com.transportation.city.repository.ScheduleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class RouteServiceTest {

    private RouteService routeService;

    private RouteRepository routeRepository;
    private RouteDtoConverter routeDtoConverter;
    private RouteConverter routeConverter;
    private StopService stopService;
    private ScheduleService scheduleService;
    @BeforeEach
    public void setUp() {
        routeRepository = Mockito.mock(RouteRepository.class);
        routeService = new RouteService(routeRepository,routeDtoConverter,routeConverter,stopService,scheduleService);
    }


    @Test
    public void testFindByScheduleId_whenScheduleIdExist_shouldReturnSchedule() {
        Route route = new Route("id","keçiören-gölbaşı",new HashSet<>());
        Mockito.when(routeRepository.findById("id")).thenReturn(Optional.of(route));

        Route result = routeService.findByRouteId("id");
        assertEquals(result, route);
    }

}