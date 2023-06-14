package com.transportation.city.converter;

import com.transportation.city.dto.StopDto;
import com.transportation.city.model.Stop;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class StopDtoConverter {

    private final RouteDtoConverter routeDtoConverter;

    public StopDtoConverter(RouteDtoConverter routeDtoConverter) {
        this.routeDtoConverter = routeDtoConverter;
    }

    public StopDto convert(Stop from){
        return new StopDto(from.getId(), from.getName(),from.getRoute().stream().map(f->routeDtoConverter.convert(f)).collect(Collectors.toSet()));
    }
}
