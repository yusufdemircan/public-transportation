package com.transportation.city.converter;

import com.transportation.city.dto.VehicleDto;
import com.transportation.city.model.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class VehicleConverter {
    private final DriverConverter driverConverter;

    public VehicleConverter(DriverConverter driverConverter) {
        this.driverConverter = driverConverter;
    }

    public Vehicle convert(VehicleDto from){
        Vehicle vehicle = new Vehicle(from.getId(), from.getVehicleType(), from.getSeats(), driverConverter.convert(from.getDriver()));
        return vehicle;
    }
}
