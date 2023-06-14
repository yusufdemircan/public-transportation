package com.transportation.city.model;

import com.transportation.city.enums.VehicleType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class Vehicle {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id = "";

    private VehicleType vehicleType;

    private Integer seats;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "driver_id",referencedColumnName = "id")
    private Driver driver;

}
