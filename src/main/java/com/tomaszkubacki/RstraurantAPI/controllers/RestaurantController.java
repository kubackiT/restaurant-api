package com.tomaszkubacki.RstraurantAPI.controllers;

import com.tomaszkubacki.RstraurantAPI.models.Restaurant;
import com.tomaszkubacki.RstraurantAPI.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @GetMapping("")
    public List<Restaurant> getAllRestaurant() {
        return restaurantRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Restaurant>> getRestaurantById(@PathVariable(value = "id") Integer restaurantId){
        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);
        return ResponseEntity.ok().body(restaurant);
    }

    @PostMapping("/")
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(
            @PathVariable(value = "id") int id,@RequestBody Restaurant restaurant)
            throws NullPointerException {
        Restaurant newRestaurant = restaurantRepository.findById(id).orElseThrow(() -> new NullPointerException("User not found on :: " + id));
        newRestaurant.setId(restaurant.getId());
        newRestaurant.setName(restaurant.getName());
        newRestaurant.setLat(restaurant.getLat());
        newRestaurant.setLon(restaurant.getLon());
        newRestaurant.setScore(restaurant.getScore());
        newRestaurant.setCuisine(restaurant.getCuisine());
        newRestaurant.setCity(restaurant.getCity());
        final Restaurant updatedRestaurant = restaurantRepository.save(newRestaurant);
        return ResponseEntity.ok(updatedRestaurant);
    }
    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteRestaurant(@PathVariable(value = "id") int id) throws NullPointerException {
        Restaurant restaurant = restaurantRepository
                        .findById(id)
                        .orElseThrow(() -> new NullPointerException("User not found on :: " + id));
        restaurantRepository.delete(restaurant);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
