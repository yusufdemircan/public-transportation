package com.transportation.city.converter;

import com.transportation.city.dto.RouteDto;
import com.transportation.city.model.Route;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
@Component
public class RouteConverter {

    private final StopConverter stopConverter;

    public RouteConverter(StopConverter stopConverter) {
        this.stopConverter = stopConverter;
    }

    public Route convert(RouteDto from){
        return new Route(from.getId(), from.getName(), from.getStops().stream().map(f->stopConverter.convert(f)).collect(Collectors.toSet()));
    }
}
