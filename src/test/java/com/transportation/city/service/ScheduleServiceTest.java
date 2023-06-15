package com.transportation.city.service;

import com.transportation.city.converter.RouteConverter;
import com.transportation.city.converter.ScheduleConverter;
import com.transportation.city.converter.SchedulerDtoConverter;
import com.transportation.city.converter.VehicleConverter;
import com.transportation.city.model.Route;
import com.transportation.city.model.Schedule;
import com.transportation.city.model.Vehicle;
import com.transportation.city.repository.ScheduleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ScheduleServiceTest {



    private ScheduleRepository scheduleRepository;

    private ScheduleService scheduleService;

    private ScheduleConverter scheduleConverter;
    private SchedulerDtoConverter schedulerDtoConverter;
    private RouteConverter routeConverter;
    private VehicleConverter vehicleConverter;

    @BeforeEach
    public void setUp(){
        scheduleRepository = Mockito.mock(ScheduleRepository.class);
        scheduleConverter = Mockito.mock(ScheduleConverter.class);
        schedulerDtoConverter = Mockito.mock(SchedulerDtoConverter.class);
        routeConverter = Mockito.mock(RouteConverter.class);
        vehicleConverter = Mockito.mock(VehicleConverter.class);
        scheduleService = new ScheduleService(scheduleRepository,scheduleConverter,schedulerDtoConverter,routeConverter,vehicleConverter);
    }


    @Test
    public void testFindByScheduleId_whenScheduleIdExist_shouldReturnSchedule(){
        Schedule schedule = new Schedule("id",new Route(), LocalDateTime.now(),LocalDateTime.now(),new Vehicle());
        Mockito.when(scheduleRepository.findById("id")).thenReturn(Optional.of(schedule));

        Schedule result = scheduleService.findByScheduleId("id");
        assertEquals(result,schedule);
    }


}