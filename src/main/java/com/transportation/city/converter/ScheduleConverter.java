package com.transportation.city.converter;

import com.transportation.city.dto.ScheduleDto;
import com.transportation.city.model.Schedule;
import org.springframework.stereotype.Component;

@Component
public class ScheduleConverter {

    private final RouteConverter routeConverter;
    private final VehicleConverter vehicleConverter;

    public ScheduleConverter(RouteConverter routeConverter, VehicleConverter vehicleConverter) {
        this.routeConverter = routeConverter;
        this.vehicleConverter = vehicleConverter;
    }

    public Schedule convert(ScheduleDto from){
        return new Schedule(from.getId(), routeConverter.convert(from.getRoute()),from.getDepartureTime(),from.getArrivalTime(),vehicleConverter.convert(from.getVehicle()));
    }
}
