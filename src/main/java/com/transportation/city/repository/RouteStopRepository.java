package com.transportation.city.repository;

import com.transportation.city.model.RouteStop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteStopRepository extends JpaRepository<RouteStop,String > {
}
