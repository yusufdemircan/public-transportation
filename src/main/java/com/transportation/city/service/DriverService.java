package com.transportation.city.service;

import com.transportation.city.converter.DriverDtoConverter;
import com.transportation.city.dto.DriverDto;
import com.transportation.city.model.Driver;
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
        Driver driver = new Driver();
        driver.setId(driver.getId());
        driver.setName(driver.getName());
        driver.setSurname(driver.getSurname());
        return driverDtoConverter.convert(driverRepository.save(driver));
    }



}
