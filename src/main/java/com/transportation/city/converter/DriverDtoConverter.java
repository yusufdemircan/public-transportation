package com.transportation.city.converter;

import com.transportation.city.dto.DriverDto;
import com.transportation.city.model.Driver;
import org.springframework.stereotype.Component;

@Component
public class DriverDtoConverter {



    public DriverDtoConverter() {
    }

    public DriverDto convert(Driver from){
        return new DriverDto(from.getId(), from.getName(), from.getSurname());
    }
}
