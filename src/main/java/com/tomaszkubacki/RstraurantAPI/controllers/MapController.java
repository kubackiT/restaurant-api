package com.tomaszkubacki.RstraurantAPI.controllers;

import com.tomaszkubacki.RstraurantAPI.models.MapItem;
import com.tomaszkubacki.RstraurantAPI.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/map")
public class MapController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @GetMapping("")
    public List<MapItem> getMap() {
        return restaurantRepository.getMap();
    }

    @GetMapping("/city/{city}")
    public ResponseEntity<Optional<List<MapItem>>> getMapForCity(@PathVariable(value = "city") String city){
        Optional<List<MapItem>> list = restaurantRepository.getMapForCity(city);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/cuisine/{cuisine}")
    public ResponseEntity<Optional<List<MapItem>>> getMapForCuisine(@PathVariable(value = "cuisine") String cuisine){
        Optional<List<MapItem>> list = restaurantRepository.getMapForCuisine(cuisine);
        return ResponseEntity.ok().body(list);
    }
}
