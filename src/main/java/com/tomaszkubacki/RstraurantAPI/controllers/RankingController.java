package com.tomaszkubacki.RstraurantAPI.controllers;

import com.tomaszkubacki.RstraurantAPI.models.Restaurant;
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
@RequestMapping("/ranking")
public class RankingController {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @GetMapping("/{number}")
    public ResponseEntity<Optional<List<Restaurant>>> getRanking(@PathVariable(value = "number") int number){
        Optional<List<Restaurant>> list = restaurantRepository.getRanking(number);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{number}/cuisine/{cuisine}")
    public ResponseEntity<Optional<List<Restaurant>>> getRankingByCuisine(@PathVariable(value = "cuisine") String cuisine,@PathVariable(value = "number") int number){
        Optional<List<Restaurant>> list = restaurantRepository.getRankingByCuisine(cuisine, number);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{number}/city/{city}")
    public ResponseEntity<Optional<List<Restaurant>>> getRankingByCity(@PathVariable(value = "city") String city,@PathVariable(value = "number") int number){
        Optional<List<Restaurant>> list = restaurantRepository.getRankingByCity(city,number);
        return ResponseEntity.ok().body(list);
    }
}
