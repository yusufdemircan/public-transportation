package com.transportation.city.controller;

import com.transportation.city.converter.StopDtoConverter;
import com.transportation.city.dto.StopDto;
import com.transportation.city.model.Stop;
import com.transportation.city.service.StopService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/stop")
public class StopController {

    private final StopService stopService;

    private final StopDtoConverter stopDtoConverter;


    public StopController(StopService stopService, StopDtoConverter stopDtoConverter) {
        this.stopService = stopService;
        this.stopDtoConverter = stopDtoConverter;
    }

    @PostMapping
    public ResponseEntity<StopDto> createStop(@RequestBody StopDto stopDto){
        return ResponseEntity.ok(stopService.createStop(stopDto));
    }

    @GetMapping
    public ResponseEntity<List<Stop>> getStops(){
        return ResponseEntity.ok(stopService.getStops());
    }

    @PutMapping
    public ResponseEntity<Stop> updateStop(@RequestBody Stop stopDto){
        return ResponseEntity.ok(stopService.updateStop(stopDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteStop(@PathVariable("id") String id) throws Exception {
        List<String> routeList = stopService.getRoutesByStopId(id);
        if(routeList.size()>0){
            throw new Exception("Rotada kayıtlı istasyon ilk önce rotadan kaldırınız!");
        }
        return ResponseEntity.ok(stopService.deleteStop(id));
    }
}
