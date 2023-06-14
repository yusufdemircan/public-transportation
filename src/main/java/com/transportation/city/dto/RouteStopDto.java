package com.transportation.city.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RouteStopDto {
    private String id;
    private RouteDto route;
    private StopDto stop;
}
