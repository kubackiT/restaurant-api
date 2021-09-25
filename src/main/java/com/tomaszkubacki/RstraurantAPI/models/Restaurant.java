package com.tomaszkubacki.RstraurantAPI.models;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;


@Entity(name = "restaurants")
@Table(name = "restaurants")
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "lat", nullable = false)
    private double lat;

    @Column(name = "lon", nullable = false)
    private double lon;

    @Column(name = "score", nullable = false)
    private double score;

    @Column(name = "cuisine", nullable = false)
    private String cuisine;

    @Column(name = "city", nullable = false)
    private String city;

}
