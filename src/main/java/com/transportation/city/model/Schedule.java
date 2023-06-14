package com.transportation.city.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class Schedule {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id = "";

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "route_id",nullable = false)
    Route route;

    LocalDateTime departureTime;

    LocalDateTime arrivalTime;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "vehicle_id",referencedColumnName = "id")
    private Vehicle vehicle;

}
