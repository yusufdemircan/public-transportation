package com.transportation.city.service;

import com.transportation.city.converter.*;
import com.transportation.city.dto.VehicleDto;
import com.transportation.city.exception.VehicleNotFoundException;
import com.transportation.city.model.Schedule;
import com.transportation.city.model.Vehicle;
import com.transportation.city.repository.ScheduleRepository;
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

    private final ScheduleRepository scheduleRepository;

    private final ScheduleService scheduleService;

    private final SchedulerDtoConverter schedulerDtoConverter;

    public VehicleService(VehicleRepository vehicleRepository,
                          VehicleDtoConverter vehicleDtoConverter,
                          VehicleConverter vehicleConverter,
                          DriverConverter driverConverter,
                          ScheduleRepository scheduleRepository, ScheduleService scheduleService, SchedulerDtoConverter schedulerDtoConverter) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleDtoConverter = vehicleDtoConverter;
        this.vehicleConverter = vehicleConverter;
        this.driverConverter = driverConverter;
        this.scheduleRepository = scheduleRepository;
        this.scheduleService = scheduleService;
        this.schedulerDtoConverter = schedulerDtoConverter;
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
        List<Vehicle> vehicleDtoList = vehicleRepository.findAll();
        if(vehicleDtoList==null){
            throw new VehicleNotFoundException("Vehicles not found");
        }
        return vehicleDtoList.stream().map(f->vehicleDtoConverter.convert(f)).collect(Collectors.toList());
    }

    public Boolean deleteVehicle(String id) throws Exception {
        Schedule schedule = scheduleService.findByVehicleId(id);
        if(schedule!=null){
            throw new Exception("The vehicle you want to delete is registered to a schedule");
        }
        vehicleRepository.deleteById(id);

        return true;
    }

    public VehicleDto updateVehicle(VehicleDto vehicleDto){
        Vehicle vehicle = vehicleRepository.findById(vehicleDto.getId()).orElseThrow(()->new VehicleNotFoundException("Vehicle Not Found"));
        vehicle.setVehicleType(vehicleDto.getVehicleType());
        vehicle.setSeats(vehicleDto.getSeats());
        vehicle.setDriver(driverConverter.convert(vehicleDto.getDriver()));
        return vehicleDtoConverter.convert(vehicleRepository.save(vehicle));
    }

    public Vehicle findByDriverId(String id){
        return vehicleRepository.findByDriver_Id(id);
    }
}
