package com.transportation.city.service;

import com.transportation.city.converter.DriverConverter;
import com.transportation.city.converter.DriverDtoConverter;
import com.transportation.city.converter.VehicleConverter;
import com.transportation.city.converter.VehicleDtoConverter;
import com.transportation.city.dto.VehicleDto;
import com.transportation.city.exception.VehicleNotFoundException;
import com.transportation.city.model.Vehicle;
import com.transportation.city.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final VehicleDtoConverter vehicleDtoConverter;

    private final DriverConverter driverConverter;
    private final VehicleConverter vehicleConverter;

    public VehicleService(VehicleRepository vehicleRepository, VehicleDtoConverter vehicleDtoConverter, VehicleConverter vehicleConverter,DriverConverter driverConverter) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleDtoConverter = vehicleDtoConverter;
        this.vehicleConverter = vehicleConverter;
        this.driverConverter = driverConverter;
    }

    public Vehicle findByVehicleId(String id){
        return vehicleRepository.findById(id).orElseThrow(()->new VehicleNotFoundException("Vehicle could not find by id : "+id));
    }

    public VehicleDto getByVehicleId(String id){
        return vehicleDtoConverter.convert(findByVehicleId(id));
    }

    public VehicleDto createVehicle(VehicleDto vehicleDto){
       return vehicleDtoConverter.convert(vehicleRepository.save(vehicleConverter.convert(vehicleDto)));
    }

    public List<VehicleDto> getVehicles(){
        return vehicleRepository.findAll().stream().map(f->vehicleDtoConverter.convert(f)).collect(Collectors.toList());
    }

    public void deleteVehicle(String id){
        vehicleRepository.deleteById(id);
    }

    public VehicleDto updateVehicle(VehicleDto vehicleDto){
        Vehicle vehicle = vehicleRepository.findById(vehicleDto.getId()).orElseThrow(()->new VehicleNotFoundException("Vehicle Not Found"));
        vehicle.setVehicleType(vehicleDto.getVehicleType());
        vehicle.setSeats(vehicle.getSeats());
        vehicle.setDriver(driverConverter.convert(vehicleDto.getDriver()));
        return vehicleDtoConverter.convert(vehicleRepository.save(vehicle));
    }

    public Vehicle findByDriverId(String id){
        return vehicleRepository.findByDriver_Id(id);
    }
}
