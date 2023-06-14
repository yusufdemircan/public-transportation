package com.transportation.city;

import com.transportation.city.enums.VehicleType;
import com.transportation.city.model.*;
import com.transportation.city.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@SpringBootApplication
public class TransportationApplication implements CommandLineRunner {

	private final DriverRepository driverRepository;
	private final VehicleRepository vehicleRepository;
	private final ScheduleRepository scheduleRepository;
	private final RouteRepository routeRepository;
	private final StopRepository stopRepository;
	private final  RouteStopRepository routeStopRepository;

	public TransportationApplication(DriverRepository driverRepository,
									 VehicleRepository vehicleRepository,
									 ScheduleRepository scheduleRepository,
									 RouteRepository routeRepository,
									 StopRepository stopRepository,
									 RouteStopRepository routeStopRepository) {
		this.driverRepository = driverRepository;
		this.vehicleRepository = vehicleRepository;
		this.scheduleRepository = scheduleRepository;
		this.routeRepository = routeRepository;
		this.stopRepository = stopRepository;
		this.routeStopRepository = routeStopRepository;
	}


	public static void main(String[] args) {
		SpringApplication.run(TransportationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	/*	Stop stop = new Stop("","OGM",new HashSet<>());
		Stop stop2 = new Stop("","belediye",new HashSet<>());
		Stop stop3 = new Stop("","yayla",new HashSet<>());
		Stop stop4 = new Stop("","etlik",new HashSet<>());

		Route route = new Route("","KECIOREN-BEŞTEPE",new HashSet<>());



		RouteStop routeStop = new RouteStop("",route,stop);
		RouteStop rs = routeStopRepository.save(routeStop);

		routeStopRepository.save(new RouteStop("",rs.getRoute(),stop2));*/

		Route route = new Route();
		route.setName("KECIOREN-BESTEPE");
		route.setId("");

		Stop stop1 = new Stop();
		stop1.setName("KECIOREN KIZLARPINARI");
		stop1.setId("");

		Stop stop2 = new Stop();
		stop2.setName("ETLIK");
		stop2.setId("");

		route.getStops().add(stop1);
		route.getStops().add(stop2);

		stop1.getRoute().add(route);
		stop2.getRoute().add(route);

		Route routeSaved = routeRepository.save(route);



		Driver driver = driverRepository.save(new Driver("", "yusuf","demircan"));
		Vehicle vehicle = vehicleRepository.save(new Vehicle("",VehicleType.BUS,40,driver));

		Schedule schedule = scheduleRepository.save(new Schedule("",routeSaved,LocalDateTime.now(),LocalDateTime.now(),vehicle));

	}
}
