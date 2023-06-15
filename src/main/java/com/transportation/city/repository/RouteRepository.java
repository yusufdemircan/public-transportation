package com.transportation.city.repository;

import com.transportation.city.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route,String > {
}
