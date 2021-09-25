package com.tomaszkubacki.RstraurantAPI.repositories;

import com.tomaszkubacki.RstraurantAPI.models.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MenuRepository extends JpaRepository<Menu, Integer> {

    @Query(value = "SELECT * FROM menus v WHERE v.restaurantid = :number",nativeQuery = true)
    Optional<List<Menu>> getMenu(int number);
}
