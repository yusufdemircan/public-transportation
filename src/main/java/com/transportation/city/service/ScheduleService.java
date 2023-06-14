package com.transportation.city.service;

import com.transportation.city.converter.ScheduleConverter;
import com.transportation.city.converter.SchedulerDtoConverter;
import com.transportation.city.dto.ScheduleDto;
import com.transportation.city.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    private final ScheduleConverter scheduleConverter;

    private final SchedulerDtoConverter schedulerDtoConverter;

    public ScheduleService(ScheduleRepository scheduleRepository, ScheduleConverter scheduleConverter, SchedulerDtoConverter schedulerDtoConverter) {
        this.scheduleRepository = scheduleRepository;
        this.scheduleConverter = scheduleConverter;
        this.schedulerDtoConverter = schedulerDtoConverter;
    }


    public ScheduleDto createSchedule(ScheduleDto scheduleDto){
        return schedulerDtoConverter.convert(scheduleRepository.save(scheduleConverter.convert(scheduleDto)));
    }

    public List<ScheduleDto> getSchedules(){
        return scheduleRepository.findAll().stream().map(f->schedulerDtoConverter.convert(f)).collect(Collectors.toList());
    }

    public void deleteSchedule(String id){
        scheduleRepository.deleteById(id);
    }
}
