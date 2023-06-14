package com.transportation.city.controller;

import com.transportation.city.converter.ScheduleConverter;
import com.transportation.city.converter.SchedulerDtoConverter;
import com.transportation.city.dto.ScheduleDto;
import com.transportation.city.model.Schedule;
import com.transportation.city.service.ScheduleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/schedule")
public class ScheduleController {


    private final SchedulerDtoConverter schedulerDtoConverter;

    private final ScheduleConverter scheduleConverter;

    private final ScheduleService scheduleService;

    public ScheduleController(SchedulerDtoConverter schedulerDtoConverter, ScheduleConverter scheduleConverter, ScheduleService scheduleService) {
        this.schedulerDtoConverter = schedulerDtoConverter;
        this.scheduleConverter = scheduleConverter;
        this.scheduleService = scheduleService;
    }


    @PostMapping
    public ResponseEntity<ScheduleDto> createSchedule(ScheduleDto scheduleDto) {
        return ResponseEntity.ok(scheduleService.createSchedule(scheduleDto));
    }

    @GetMapping
    public ResponseEntity<List<Schedule>> getSchedules(){
        return ResponseEntity.ok(scheduleService.getSchedules());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteSchedule(@PathVariable("id") String id){
        return ResponseEntity.ok(scheduleService.deleteSchedule(id));
    }

    @PutMapping
    public ResponseEntity<ScheduleDto> updateSchedule(@RequestBody Schedule schedule){
        return ResponseEntity.ok(scheduleService.updateSchedule(schedule));
    }
}
