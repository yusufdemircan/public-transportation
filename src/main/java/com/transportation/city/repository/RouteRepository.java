package com.transportation.city.repository;

import com.transportation.city.model.Route;
import com.transportation.city.model.Stop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route,String > {
}
