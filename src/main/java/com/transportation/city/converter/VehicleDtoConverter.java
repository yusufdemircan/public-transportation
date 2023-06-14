package com.transportation.city.converter;

import com.transportation.city.dto.DriverDto;
import com.transportation.city.dto.VehicleDto;
import com.transportation.city.enums.VehicleType;
import com.transportation.city.model.Driver;
import com.transportation.city.model.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class VehicleDtoConverter {

    private final DriverDtoConverter driverDtoConverter;

    public VehicleDtoConverter(DriverDtoConverter driverDtoConverter) {
        this.driverDtoConverter = driverDtoConverter;
    }

    public VehicleDto convert(Vehicle from){
        if(from==null)
            return new VehicleDto();
        if(from.getDriver()==null)
            from.setDriver(new Driver());
        return new VehicleDto(from.getId(), from.getVehicleType(),from.getSeats(),driverDtoConverter.convert(from.getDriver()));
    }
}
