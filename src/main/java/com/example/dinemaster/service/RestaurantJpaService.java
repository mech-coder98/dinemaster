/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * 
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 */

// Write your code here

package com.example.dinemaster.service;

import java.util.*;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;
import com.example.dinemaster.model.Restaurant;
import com.example.dinemaster.repository.*;
import org.springframework.http.HttpStatus;

@Service
public class RestaurantJpaService implements RestaurantRepository {

    @Autowired
    private RestaurantJpaRepository restaurantRepository;

    @Override
    public ArrayList<Restaurant> getAllRestaurants() {
        List<Restaurant> restaurantList = restaurantRepository.findAll();
        ArrayList<Restaurant> restaurants = new ArrayList<>(restaurantList);
        return restaurants;
    }

    @Override
    public Restaurant getRestaurantById(int restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();
        return restaurant;
    }

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
        return restaurant;
    }

    @Override
    public Restaurant updateRestaurant(int restaurantId, Restaurant restaurant) {
        try {
            Restaurant updateRestaurant = restaurantRepository.findById(restaurantId).get();
            if (restaurant.getName() != null) {
                updateRestaurant.setName(restaurant.getName());
            }
            if (restaurant.getAddress() != null) {
                updateRestaurant.setAddress(restaurant.getAddress());
            }
            if (restaurant.getCuisineType() != null) {
                updateRestaurant.setAddress(restaurant.getCuisineType());
            }
            if (restaurant.getRating() != 0) {
                updateRestaurant.setRating(restaurant.getRating());
            }
            restaurantRepository.save(updateRestaurant);
            return updateRestaurant;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override

    public void deleteRestaurant(int restaurantId) {
        try {
            restaurantRepository.deleteById(restaurantId);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

}