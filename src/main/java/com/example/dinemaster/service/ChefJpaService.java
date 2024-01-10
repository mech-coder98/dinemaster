/*
 *
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 */

// Write your code here

package com.example.dinemaster.service;

import com.example.dinemaster.repository.*;
import com.example.dinemaster.model.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ChefJpaService implements ChefRepository {

    @Autowired
    private ChefJpaRepository chefRepository;

    @Autowired
    private RestaurantJpaService restaurantService;

    @Override
    public ArrayList<Chef> getAllChefs() {
        List<Chef> chefList = chefRepository.findAll();
        ArrayList<Chef> chefs = new ArrayList<>(chefList);
        return chefs;
    }

    @Override
    public Chef getChefById(int chefId) {
        Chef chef = chefRepository.findById(chefId).get();
        return chef;
    }

    @Override
    public Chef addChef(Chef chef) {
        int restaurantId = chef.getRestaurant().getId();
        Restaurant restaurant = restaurantService.getRestaurantById(restaurantId);
        chef.setRestaurant(restaurant);
        chefRepository.save(chef);
        return chef;

    }

    @Override
    public Chef updateChef(int chefId, Chef chef) {
        try {
            Chef updateChef = chefRepository.findById(chefId).get();
            if (chef.getRestaurant() != null) {
                int restaurantId = chef.getRestaurant().getId();
                Restaurant newRestaurant = restaurantService.getRestaurantById(restaurantId);
                updateChef.setRestaurant(newRestaurant);
            }
            if (chef.getFirstName() != null) {
                updateChef.setFirstName(chef.getFirstName());
            }
            if (chef.getLastName() != null) {
                updateChef.setLastName(chef.getLastName());
            }
            if (chef.getExpertise() != null) {
                updateChef.setExpertise(chef.getExpertise());
            }
            if (chef.getExperienceYears() != 0) {
                updateChef.setExperienceYears(chef.getExperienceYears());
            }
            chefRepository.save(updateChef);
            return updateChef;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteChef(int chefId) {
        try {
            chefRepository.deleteById(chefId);

        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

    @Override
    public Restaurant getChefRestaurant(int chefId) {
        try {
            Chef chef = chefRepository.findById(chefId).get();
            Restaurant restaurant = chef.getRestaurant();
            return restaurant;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

}