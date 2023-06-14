package com.transportation.city.service;

import com.transportation.city.converter.DriverConverter;
import com.transportation.city.converter.DriverDtoConverter;
import com.transportation.city.converter.VehicleConverter;
import com.transportation.city.converter.VehicleDtoConverter;
import com.transportation.city.dto.DriverDto;
import com.transportation.city.dto.VehicleDto;
import com.transportation.city.enums.VehicleType;
import com.transportation.city.exception.VehicleNotFoundException;
import com.transportation.city.model.Driver;
import com.transportation.city.model.Vehicle;
import com.transportation.city.repository.VehicleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class VehicleServiceTest {

    private VehicleRepository vehicleRepository;
    private VehicleService vehicleService;

    private VehicleDtoConverter vehicleDtoConverter;

    private DriverConverter driverConverter;

    private VehicleConverter vehicleConverter;

    @BeforeEach
    public void setUp(){
        vehicleRepository = mock(VehicleRepository.class);
        vehicleDtoConverter = mock(VehicleDtoConverter.class);
        driverConverter = mock(DriverConverter.class);
        vehicleConverter = new VehicleConverter(driverConverter);

        vehicleDtoConverter = mock(VehicleDtoConverter.class);
    }

    @Test
    void findByVehicleId() {
        Mockito.when(vehicleRepository.findById("id")).thenReturn(Optional.empty());
        assertThrows(VehicleNotFoundException.class,()->vehicleService.findByVehicleId("id"));
        Mockito.verifyNoInteractions(vehicleConverter);
    }

    @Test
    void createVehicle() {
        Vehicle vehicle = new Vehicle("id", VehicleType.BUS,40,new Driver("id","yusuf","demircan"));
        VehicleDto vehicleDto = new VehicleDto("id",VehicleType.BUS,40,new DriverDto("id","yusuf","demircan"));

        Mockito.when(vehicleRepository.findById("id")).thenReturn(Optional.of(vehicle));
        Mockito.when(vehicleDtoConverter.convert(vehicle)).thenReturn(vehicleDto);

        VehicleDto result = vehicleService.getByVehicleId("id");
        assertEquals(result,vehicleDto);

    }


}