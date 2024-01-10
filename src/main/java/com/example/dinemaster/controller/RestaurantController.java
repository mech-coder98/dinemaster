/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * import java.util.ArrayList;
 * 
 */

// Write your code here

package com.example.dinemaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import com.example.dinemaster.model.*;
import org.springframework.web.bind.annotation.*;
import com.example.dinemaster.service.*;

@RestController
public class RestaurantController {

    @Autowired
    public RestaurantJpaService restaurantJpaService;

    @GetMapping("/restaurants")
    public ArrayList<Restaurant> getAllRestaurants() {
        return restaurantJpaService.getAllRestaurants();
    }

    @GetMapping("/restaurants/{restaurantId}")
    public Restaurant getRestaurantById(@PathVariable("restaurantId") int restaurantId) {
        return restaurantJpaService.getRestaurantById(restaurantId);
    }

    @PostMapping("/restaurants")
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantJpaService.addRestaurant(restaurant);
    }

    @PutMapping("/restaurants/{restaurantId}")
    public Restaurant updateRestaurant(@PathVariable("restaurantId") int restaurantId,
            @RequestBody Restaurant restaurant) {
        return restaurantJpaService.updateRestaurant(restaurantId, restaurant);
    }

    @DeleteMapping("/restaurants/{restaurantId}")
    public void deleteRestaurant(@PathVariable("restaurantId") int restaurantId) {
        restaurantJpaService.deleteRestaurant(restaurantId);
    }

}