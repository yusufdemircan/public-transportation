package com.transportation.city.converter;

import com.transportation.city.dto.DriverDto;
import com.transportation.city.model.Driver;
import org.springframework.stereotype.Component;

@Component
public class DriverDtoConverter {

    private final VehicleDtoConverter vehicleDtoConverter;

    public DriverDtoConverter(VehicleDtoConverter vehicleDtoConverter) {
        this.vehicleDtoConverter = vehicleDtoConverter;
    }

    public DriverDto convert(Driver from){
        return new DriverDto(from.getId(), from.getName(), from.getSurname());
    }
}
