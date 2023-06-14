package com.transportation.city.service;

import com.transportation.city.converter.RouteConverter;
import com.transportation.city.converter.RouteDtoConverter;
import com.transportation.city.dto.RouteDto;
import com.transportation.city.exception.MustBeRouteHaveStops;
import com.transportation.city.model.Route;
import com.transportation.city.repository.RouteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RouteService {

    private final RouteRepository routeRepository;

    private final RouteDtoConverter routeDtoConverter;

    private final RouteConverter routeConverter;

    private final StopService stopService;

    public RouteService(RouteRepository routeRepository, RouteDtoConverter routeDtoConverter, RouteConverter routeConverter, StopService stopService) {
        this.routeRepository = routeRepository;
        this.routeDtoConverter = routeDtoConverter;
        this.routeConverter = routeConverter;
        this.stopService = stopService;
    }


    public RouteDto createRoute(RouteDto routeDto){
        if(routeDto.getStops().size()<2)
            throw new MustBeRouteHaveStops("Rota oluşturulur iken en az 2 durak seçmelisiniz!");
        RouteDto rtd = routeDtoConverter.convert(routeRepository.save(routeConverter.convert(routeDto)));
        if (rtd.getStops().size()>0)
            rtd.getStops().forEach(f->{f.getRoute().add(rtd);stopService.updateStop(f);});
        return rtd;
    }

    public List<RouteDto> getRoutes(){
        return routeRepository.findAll().stream().map(f->routeDtoConverter.convert(f)).collect(Collectors.toList());
    }

    public void deleteRoute(String id){
        routeRepository.deleteById(id);
    }

    public RouteDto updateRoute(RouteDto routeDto){
        Route route = routeConverter.convert(routeDto);
        return routeDtoConverter.convert(routeRepository.save(route));
    }




}
