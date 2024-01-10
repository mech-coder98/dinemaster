/*
 *
 * You can use the following import statements
 * 
 * import java.util.ArrayList;
 * 
 */

// Write your code here

package com.example.dinemaster.repository;

import java.util.*;
import com.example.dinemaster.model.*;

public interface ChefRepository {
    ArrayList<Chef> getAllChefs();

    Chef getChefById(int chefId);

    Chef addChef(Chef chef);

    Chef updateChef(int chefId, Chef chef);

    void deleteChef(int chefId);

    Restaurant getChefRestaurant(int chefId);
}