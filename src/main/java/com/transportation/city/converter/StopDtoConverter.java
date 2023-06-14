package com.transportation.city.converter;

import com.transportation.city.dto.RouteDto;
import com.transportation.city.dto.StopDto;
import com.transportation.city.model.Route;
import com.transportation.city.model.Stop;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class StopDtoConverter {



    public StopDtoConverter() {

    }

    public StopDto convert(Stop from){
        return new StopDto(from.getId(), from.getName(),from.getRoute().stream().map(f->convert2(f)).collect(Collectors.toSet()));
    }

    public RouteDto convert2(Route from){
        return new RouteDto(from.getId(),from.getName(),from.getStops().stream().map(f->convert(f)).collect(Collectors.toSet()));
    }
}
