package com.transportation.city.controller;

import com.transportation.city.converter.VehicleDtoConverter;
import com.transportation.city.dto.DriverDto;
import com.transportation.city.model.Driver;
import com.transportation.city.model.Vehicle;
import com.transportation.city.service.DriverService;
import com.transportation.city.service.VehicleService;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<DriverDto> createDriver(@RequestBody DriverDto request){
        return ResponseEntity.ok(driverService.createDriver(request));
    }

    @GetMapping
    public ResponseEntity<List<DriverDto>> getDrivers(){
        return ResponseEntity.ok(driverService.getDrivers());
    }

    @DeleteMapping("/{id}")
    public void deleteDriver(@PathVariable("id") String id){
        Vehicle vehicle=vehicleService.findByDriverId(id);
        if(vehicle!=null){
            vehicle.setDriver(new Driver());
            vehicleService.updateVehicle(vehicleDtoConverter.convert(vehicle));
        }
        driverService.deleteDriver(id);
    }

    @PutMapping
    public ResponseEntity<DriverDto> updateDriver(@RequestBody DriverDto request){
        return ResponseEntity.ok(driverService.updateDriver(request));
    }
}
