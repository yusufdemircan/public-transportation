package com.transportation.city.converter;

import com.transportation.city.dto.DriverDto;
import com.transportation.city.model.Driver;
import org.springframework.stereotype.Component;

@Component
public class DriverConverter {

    public Driver convert(DriverDto from){
        return new Driver(from.getId(), from.getName(), from.getSurname());
    }
}
