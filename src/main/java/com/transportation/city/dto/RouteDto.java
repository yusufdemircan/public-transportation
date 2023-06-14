package com.transportation.city.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RouteDto {
    private String id;
    private String name;
    private Set<StopDto> stops;
}
