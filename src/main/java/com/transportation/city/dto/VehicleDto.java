package com.transportation.city.dto;

import com.transportation.city.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class VehicleDto {
    private String id;
    private VehicleType vehicleType;
    private Integer seats;
    private DriverDto driver;
}
