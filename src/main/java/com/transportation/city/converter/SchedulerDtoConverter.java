package com.transportation.city.converter;

import com.transportation.city.dto.ScheduleDto;
import com.transportation.city.model.Schedule;
import org.springframework.stereotype.Component;

@Component
public class SchedulerDtoConverter {

    private final StopDtoConverter stopDtoConverter;
    private final RouteDtoConverter routeDtoConverter;
    private final VehicleDtoConverter vehicleDtoConverter;

    public SchedulerDtoConverter(StopDtoConverter stopDtoConverter, RouteDtoConverter routeDtoConverter, VehicleDtoConverter vehicleDtoConverter) {
        this.stopDtoConverter = stopDtoConverter;
        this.routeDtoConverter = routeDtoConverter;
        this.vehicleDtoConverter = vehicleDtoConverter;
    }

    public ScheduleDto convert(Schedule from){
        return new ScheduleDto(from.getId(),routeDtoConverter.convert(from.getRoute()),from.getDepartureTime(),from.getArrivalTime(),vehicleDtoConverter.convert(from.getVehicle()));
    }
}
