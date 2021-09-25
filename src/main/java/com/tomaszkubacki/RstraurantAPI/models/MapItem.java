package com.tomaszkubacki.RstraurantAPI.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MapItem {
    private String name;
    private double lat;
    private double lon;
    private String cuisine;
}
