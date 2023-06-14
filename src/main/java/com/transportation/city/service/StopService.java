package com.transportation.city.service;

import com.transportation.city.converter.StopConverter;
import com.transportation.city.converter.StopDtoConverter;
import com.transportation.city.dto.StopDto;
import com.transportation.city.model.Stop;
import com.transportation.city.repository.StopRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StopService {

    private final StopRepository stopRepository;
    private final StopConverter stopConverter;
    private final StopDtoConverter stopDtoConverter;
    public StopService(StopRepository stopRepository, StopConverter stopConverter, StopDtoConverter stopDtoConverter) {
        this.stopRepository = stopRepository;
        this.stopConverter = stopConverter;
        this.stopDtoConverter = stopDtoConverter;
    }

    public StopDto createStop(StopDto stopDto){
        return stopDtoConverter.convert(stopRepository.save(stopConverter.convert(stopDto)));
    }

    public List<StopDto> getStops(){
        return stopRepository.findAll().stream().map(f->stopDtoConverter.convert(f)).collect(Collectors.toList());
    }

    public void deleteStop(String id){
        stopRepository.deleteById(id);
    }

    public StopDto updateStop(StopDto stopDto){
        Stop stop = stopConverter.convert(stopDto);
        return stopDtoConverter.convert(stopRepository.save(stop));
    }
}
