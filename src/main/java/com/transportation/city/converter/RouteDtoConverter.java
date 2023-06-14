package com.transportation.city.converter;

import com.transportation.city.dto.RouteDto;
import com.transportation.city.model.Route;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class RouteDtoConverter {

    private StopDtoConverter stopDtoConverter;

    public RouteDtoConverter(StopDtoConverter stopDtoConverter) {
        this.stopDtoConverter = stopDtoConverter;
    }

    public RouteDto convert(Route from){
        return new RouteDto(from.getId(),from.getName(),from.getStops().stream().map(f->stopDtoConverter.convert(f)).collect(Collectors.toSet()));
    }
}
