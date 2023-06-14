package com.transportation.city.converter;

import com.transportation.city.dto.VehicleDto;
import com.transportation.city.model.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class VehicleDtoConverter {

    private final DriverDtoConverter driverDtoConverter;

    public VehicleDtoConverter(DriverDtoConverter driverDtoConverter) {
        this.driverDtoConverter = driverDtoConverter;
    }

    public VehicleDto convert(Vehicle from){
        return new VehicleDto(from.getId(), from.getVehicleType(),from.getSeats(),driverDtoConverter.convert(from.getDriver()));
    }
}
