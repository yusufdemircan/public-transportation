package com.transportation.city.repository;

import com.transportation.city.model.Stop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StopRepository extends JpaRepository<Stop,String> {
}
