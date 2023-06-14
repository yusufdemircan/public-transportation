package com.transportation.city.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StopDto {
    private String id;
    private String name;
    private Set<RouteDto> route= new HashSet<>();
}
