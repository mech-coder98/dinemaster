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

import com.example.dinemaster.service.ChefJpaService;
import com.example.dinemaster.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.example.dinemaster.repository.ChefRepository;
import java.util.*;

@RestController
public class ChefController {

    @Autowired
    private ChefJpaService chefService;

    @GetMapping("/restaurants/chefs")
    public ArrayList<Chef> getAllChefs() {
        return chefService.getAllChefs();
    }

    @GetMapping("/restaurants/chefs/{chefId}")
    public Chef getChefById(@PathVariable("chefId") int chefId) {
        return chefService.getChefById(chefId);
    }

    @PostMapping("/restaurants/chefs")
    public Chef addChef(@RequestBody Chef chef) {
        return chefService.addChef(chef);
    }

    @PutMapping("/restaurants/chefs/{chefId}")
    public Chef updateChef(@PathVariable("chefId") int chefId, @RequestBody Chef chef) {
        return chefService.updateChef(chef);
    }

    @DeleteMapping("/restaurants/chefs/{chefId}")
    public void deleteChef(@PathVariable("chefId") int chefId) {
        chefService.deleteChef(chefId);

    }

    @GetMapping("/chefs/{chefId}/restaurants")
    public Restaurant getChefRestaurant(@PathVariable("chefId") int chefId) {
        return chefService.getChefRestaurant(chefId);

    }

}