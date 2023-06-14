package com.transportation.city.service;

import com.transportation.city.converter.StopConverter;
import com.transportation.city.converter.StopDtoConverter;
import com.transportation.city.dto.StopDto;
import com.transportation.city.exception.StopNotFoundException;
import com.transportation.city.model.Stop;
import com.transportation.city.repository.StopRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Stop> getStops(){
        return stopRepository.findAll();
    }

    public Boolean deleteStop(String id){
        Stop stop = stopRepository.findById(id).orElseThrow(()->new StopNotFoundException("Stop could not find id : "+id));
        stopRepository.deleteById(id);
        return true;
    }

    public Stop updateStop(Stop stopReq){
        Stop stop = stopRepository.findById(stopReq.getId()).orElseThrow(()->new StopNotFoundException("Stop not find by id : "+stopReq.getId()));
        stop.setName(stopReq.getName());
        stop.setRoute(stopReq.getRoute());
        return stopRepository.save(stop);
    }

    public List<String> getRoutesByStopId(String stopId){
        return stopRepository.getRouteListByStop(stopId);
    }
}
