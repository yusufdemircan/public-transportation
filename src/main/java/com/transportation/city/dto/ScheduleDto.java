package com.transportation.city.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ScheduleDto {

    private String id;
    private RouteDto route;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private VehicleDto vehicle;
}
