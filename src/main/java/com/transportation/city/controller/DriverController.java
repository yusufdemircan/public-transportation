package com.transportation.city.controller;

import com.transportation.city.converter.VehicleDtoConverter;
import com.transportation.city.dto.DriverDto;
import com.transportation.city.model.Vehicle;
import com.transportation.city.service.DriverService;
import com.transportation.city.service.VehicleService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/driver")
public class DriverController {

    private final DriverService driverService;
    private final VehicleService vehicleService;

    private final VehicleDtoConverter vehicleDtoConverter;

    public DriverController(DriverService driverService, VehicleService vehicleService, VehicleDtoConverter vehicleDtoConverter) {
        this.driverService = driverService;
        this.vehicleService = vehicleService;
        this.vehicleDtoConverter = vehicleDtoConverter;
    }

    @PostMapping
    public ResponseEntity<DriverDto> createDriver(@Valid @RequestBody DriverDto request) {
        return ResponseEntity.ok(driverService.createDriver(request));
    }

    @GetMapping
    public ResponseEntity<List<DriverDto>> getDrivers() {
        return ResponseEntity.ok(driverService.getDrivers());
    }

    @DeleteMapping("/{id}")
    public void deleteDriver(@PathVariable("id") String id) {
        Vehicle vehicle = vehicleService.findByDriverId(id);
        Assert.isNull(vehicle,"Şoför bir araca kayıtlı");
        driverService.deleteDriver(id);
    }

    @PutMapping
    public ResponseEntity<DriverDto> updateDriver(@Valid @RequestBody DriverDto request) {
        return ResponseEntity.ok(driverService.updateDriver(request));
    }
}
