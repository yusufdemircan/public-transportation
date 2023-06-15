package com.transportation.city.controller;

import com.transportation.city.model.Route;
import com.transportation.city.service.RouteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/route")
public class RouteController {

    private final RouteService routeService;

    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @PostMapping
    public ResponseEntity<Route> createRoute(@RequestBody Route route){
        return ResponseEntity.ok(routeService.createRoute(route));
    }

    @GetMapping
    public ResponseEntity<List<Route>> getRoutes(){
        return ResponseEntity.ok(routeService.getRoutes());
    }

    @PutMapping
    public ResponseEntity<Route> updateRoute(@RequestBody Route route){
        return ResponseEntity.ok(routeService.updateRoute(route));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteRoute(@PathVariable("id") String id) throws Exception {
        return ResponseEntity.ok(routeService.deleteRoute(id));
    }
}
