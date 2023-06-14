package com.transportation.city.controller;

import com.transportation.city.dto.VehicleDto;
import com.transportation.city.service.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/vehicle")
public class VehicleController {
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping
    public ResponseEntity<VehicleDto> createVehicle(@RequestBody VehicleDto vehicleDto){
        return ResponseEntity.ok(vehicleService.createVehicle(vehicleDto));
    }

    @GetMapping
    public ResponseEntity<List<VehicleDto>> getVehicles(){
        return ResponseEntity.ok(vehicleService.getVehicles());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVehicle(@PathVariable("id") String id) throws Exception {

        return ResponseEntity.ok(vehicleService.deleteVehicle(id));
    }

    @PutMapping
    public ResponseEntity<VehicleDto> updateVehicle(@RequestBody VehicleDto vehicleDto){
        return ResponseEntity.ok(vehicleService.updateVehicle(vehicleDto));
    }
}
