package com.transportation.city.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverDto {
    private String id;
    @NotBlank(message = "bu alan boş bırakılamaz")
    private String name;
    @NotBlank(message = "bu alan boş bırakılamaz")
    private String surname;
}
