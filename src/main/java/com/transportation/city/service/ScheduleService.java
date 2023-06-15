package com.transportation.city.service;

import com.transportation.city.converter.RouteConverter;
import com.transportation.city.converter.ScheduleConverter;
import com.transportation.city.converter.SchedulerDtoConverter;
import com.transportation.city.converter.VehicleConverter;
import com.transportation.city.dto.ScheduleDto;
import com.transportation.city.exception.ScheduleNotFoundException;
import com.transportation.city.model.Schedule;
import com.transportation.city.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    private final ScheduleConverter scheduleConverter;

    private final SchedulerDtoConverter schedulerDtoConverter;

    private final RouteConverter routeConverter;

    private final VehicleConverter vehicleConverter;

    public ScheduleService(ScheduleRepository scheduleRepository,
                           ScheduleConverter scheduleConverter,
                           SchedulerDtoConverter schedulerDtoConverter,
                           RouteConverter routeConverter,
                           VehicleConverter vehicleConverter) {
        this.scheduleRepository = scheduleRepository;
        this.scheduleConverter = scheduleConverter;
        this.schedulerDtoConverter = schedulerDtoConverter;
        this.routeConverter = routeConverter;
        this.vehicleConverter = vehicleConverter;
    }


    public ScheduleDto createSchedule(ScheduleDto scheduleDto){
        return schedulerDtoConverter.convert(scheduleRepository.save(scheduleConverter.convert(scheduleDto)));
    }

    public List<Schedule> getSchedules(){
        return scheduleRepository.findAll();
    }

    public Boolean deleteSchedule(String id){
        scheduleRepository.deleteById(id);
        return true;
    }

    public Schedule findByVehicleId(String id){
        return scheduleRepository.findByVehicleId(id);
    }

    public ScheduleDto updateSchedule(Schedule update){
        Schedule schedule = scheduleRepository.findById(update.getId()).orElseThrow( ()-> new ScheduleNotFoundException("Schedule could not find by id"+update.getId()));
        schedule.setRoute(update.getRoute());
        schedule.setArrivalTime(update.getArrivalTime());
        schedule.setDepartureTime(update.getDepartureTime());
        schedule.setVehicle(update.getVehicle());
        return schedulerDtoConverter.convert(scheduleRepository.save(schedule));
    }

    public Schedule findByRouteId(String id){
        return scheduleRepository.findByRouteId(id);
    }

    public Schedule findByScheduleId(String id) {
        return scheduleRepository.findById(id).orElseThrow(()->new ScheduleNotFoundException("Schedule could not find id : "+id));
    }
}
