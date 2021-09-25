package com.tomaszkubacki.RstraurantAPI.controllers;

import com.tomaszkubacki.RstraurantAPI.models.Menu;
import com.tomaszkubacki.RstraurantAPI.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuRepository menuRepository;


    @GetMapping("/{id}")
    public ResponseEntity<Optional<List<Menu>>> getMenuForRestaurant(@PathVariable(value = "id") int id){
        Optional<List<Menu>> list = menuRepository.getMenu(id);
        return ResponseEntity.ok().body(list);
    }

    @PostMapping("/")
    public Menu createMenuItem(@RequestBody Menu menu) {
        return menuRepository.save(menu);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Menu> updatedMenuItem(
            @PathVariable(value = "id") int id,@RequestBody Menu menu)
            throws NullPointerException {
        Menu newMenuItem = menuRepository
                .findById(id)
                .orElseThrow(() -> new NullPointerException("User not found on :: " + id));
        newMenuItem.setId(id);
        newMenuItem.setName(menu.getName());
        newMenuItem.setRestaurantid(menu.getRestaurantid());
        newMenuItem.setPrice(menu.getPrice());
        newMenuItem.setCategory(menu.getCategory());

        final Menu updatedMenuItem = menuRepository.save(newMenuItem);
        return ResponseEntity.ok(updatedMenuItem);
    }
    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteMenuItem(@PathVariable(value = "id") int id) throws NullPointerException {
        Menu menuItem = menuRepository
                .findById(id)
                .orElseThrow(() -> new NullPointerException("User not found on :: " + id));
        menuRepository.delete(menuItem);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
