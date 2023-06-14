package com.transportation.city.repository;

import com.transportation.city.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle,String> {

    public Vehicle findByDriver_Id(String id);
}
