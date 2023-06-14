package com.transportation.city.repository;

import com.transportation.city.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule,String> {
    public Schedule findByVehicleId(String id);
}
