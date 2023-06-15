package com.transportation.city.service;

import com.transportation.city.converter.RouteConverter;
import com.transportation.city.converter.RouteDtoConverter;
import com.transportation.city.exception.MustBeRouteHaveStops;
import com.transportation.city.exception.RouteNotFoundException;
import com.transportation.city.model.Route;
import com.transportation.city.model.Schedule;
import com.transportation.city.repository.RouteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {

    private final RouteRepository routeRepository;

    private final RouteDtoConverter routeDtoConverter;

    private final RouteConverter routeConverter;

    private final StopService stopService;

    private final ScheduleService scheduleService;

    public RouteService(RouteRepository routeRepository, RouteDtoConverter routeDtoConverter, RouteConverter routeConverter, StopService stopService, ScheduleService scheduleService) {
        this.routeRepository = routeRepository;
        this.routeDtoConverter = routeDtoConverter;
        this.routeConverter = routeConverter;
        this.stopService = stopService;
        this.scheduleService = scheduleService;
    }


    public Route createRoute(Route routeDto){
        if(routeDto.getStops().size()<2)
            throw new MustBeRouteHaveStops("Rota oluşturulur iken en az 2 durak seçmelisiniz!");
        Route rtd =routeRepository.save(routeDto);
        return rtd;
    }

    public List<Route> getRoutes(){
        return routeRepository.findAll();
    }

    public Boolean deleteRoute(String id) throws Exception {
        Schedule schedule = scheduleService.findByRouteId(id);
        if(schedule!=null){
            throw new Exception("Rotayı kaldırmadan önce oluşturulan plandan rotayı değiştirin");
        }
        routeRepository.deleteById(id);
        return true;
    }

    public Route updateRoute(Route routeDto){
        Route route = routeRepository.findById(routeDto.getId()).orElseThrow(()->new RouteNotFoundException("Route could not find id : "+routeDto.getId()));
        route.setName(routeDto.getName());
        route.setStops(routeDto.getStops());
        return routeRepository.save(route);
    }

}
