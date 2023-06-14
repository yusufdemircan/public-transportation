package com.transportation.city.service;

import com.transportation.city.converter.DriverDtoConverter;
import com.transportation.city.exception.DriverNotFoundException;
import com.transportation.city.model.Driver;
import com.transportation.city.repository.DriverRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.mockito.Mockito.mock;

import static org.junit.jupiter.api.Assertions.*;

public class DriverServiceTest {
    private DriverService driverService;

    private DriverRepository driverRepository;

    private DriverDtoConverter driverDtoConverter;

    @BeforeEach
    public void setUp(){
        driverRepository = mock(DriverRepository.class);
        driverDtoConverter = mock(DriverDtoConverter.class);
        driverService = new DriverService(driverRepository,driverDtoConverter);
    }

    @Test
    public void testFindByDriverId_whenDriverIdExist_shouldReturnDriver(){
        Driver driver = new Driver("id","yusuf","demircan");
        Mockito.when(driverRepository.findById("id")).thenReturn(Optional.of(driver));

        Driver result = driverService.findByDriverId("id");
        assertEquals(result,driver);
    }

    @Test
    public void testGetDriverById_whenDriverIdDoesNotExist_shouldThrowDriverNotFoundException() {
        Mockito.when(driverRepository.findById("id")).thenReturn(Optional.empty());
        assertThrows(DriverNotFoundException.class,()-> driverService.findByDriverId("id"));
        Mockito.verifyNoInteractions(driverDtoConverter);
    }
}