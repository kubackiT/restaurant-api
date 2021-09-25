package com.tomaszkubacki.RstraurantAPI.repositories;

import com.tomaszkubacki.RstraurantAPI.models.MapItem;
import com.tomaszkubacki.RstraurantAPI.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {


    @Query("SELECT new com.tomaszkubacki.RstraurantAPI.models.MapItem(v.name,v.lat,v.lon,v.cuisine) FROM restaurants v ")
    List<MapItem> getMap();

    @Query("SELECT new com.tomaszkubacki.RstraurantAPI.models.MapItem(v.name,v.lat,v.lon,v.cuisine) FROM restaurants v WHERE v.city = :city")
    Optional<List<MapItem>> getMapForCity(String city);

    @Query("SELECT new com.tomaszkubacki.RstraurantAPI.models.MapItem(v.name,v.lat,v.lon,v.cuisine) FROM restaurants v  WHERE v.cuisine = :cuisine")
    Optional<List<MapItem>> getMapForCuisine(String cuisine);

    @Query(value = "SELECT * FROM restaurants v ORDER BY v.score DESC LIMIT :number",nativeQuery = true)
    Optional<List<Restaurant>> getRanking(int number);

    @Query(value = "SELECT * FROM restaurants v WHERE v.cuisine = :cuisine ORDER BY v.score DESC LIMIT :number",nativeQuery = true)
    Optional<List<Restaurant>> getRankingByCuisine(String cuisine, int number);

    @Query(value = "SELECT * FROM restaurants v WHERE v.city = :city ORDER BY v.score DESC LIMIT :number",nativeQuery = true)
    Optional<List<Restaurant>> getRankingByCity(String city, int number);
}
