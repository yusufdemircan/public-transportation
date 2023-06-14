package com.transportation.city.service;

import com.transportation.city.converter.DriverDtoConverter;
import com.transportation.city.dto.DriverDto;
import com.transportation.city.exception.DriverNotFoundException;
import com.transportation.city.exception.VehicleNotFoundException;
import com.transportation.city.model.Driver;
import com.transportation.city.model.Vehicle;
import com.transportation.city.repository.DriverRepository;
import com.transportation.city.request.CreateDriverRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DriverService {
    private final DriverRepository driverRepository;
    private final DriverDtoConverter driverDtoConverter;

    public DriverService(DriverRepository driverRepository, DriverDtoConverter driverDtoConverter) {
        this.driverRepository = driverRepository;
        this.driverDtoConverter = driverDtoConverter;
    }



    public Driver findByDriverId(String id){
        return driverRepository.findById(id).orElseThrow(()->new DriverNotFoundException("Driver could not find by id : "+id));
    }

    public DriverDto createDriver(DriverDto driverDto){
        return driverDtoConverter.convert(driverRepository.save(new Driver("",driverDto.getName(),driverDto.getSurname())));
    }

    public List<DriverDto> getDrivers(){
        return driverRepository.findAll().stream().map(f->driverDtoConverter.convert(f)).collect(Collectors.toList());
    }

    public void deleteDriver(String id){
       driverRepository.deleteById(id);
    }

    public DriverDto updateDriver(DriverDto driverDto){
        Driver driver = driverRepository.findById(driverDto.getId()).orElse(new Driver());
        driver.setName(driverDto.getName());
        driver.setSurname(driverDto.getSurname());
        return driverDtoConverter.convert(driverRepository.save(driver));
    }



}
