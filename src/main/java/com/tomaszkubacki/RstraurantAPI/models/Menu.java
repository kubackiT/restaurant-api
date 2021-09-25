package com.tomaszkubacki.RstraurantAPI.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity(name = "menus")
@Table(name = "menus")
@EntityListeners(AuditingEntityListener.class)
@Data
@NoArgsConstructor
public class Menu {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "restaurantid", nullable = false)
    private String restaurantid;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "category", nullable = false)
    private String category;
}
