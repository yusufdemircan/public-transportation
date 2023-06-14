package com.transportation.city.repository;

import com.transportation.city.model.Stop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StopRepository extends JpaRepository<Stop,String> {
    @Query(nativeQuery = true,value = "select rs.route_id from route_stops rs where rs.stop_id=:prmStopId")
    public List<String> getRouteListByStop(@Param("prmStopId") String stopId);
}
