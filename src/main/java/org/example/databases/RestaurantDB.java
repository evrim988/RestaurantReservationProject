package org.example.databases;

import org.example.entities.Restaurant;
import org.example.utility.DatabaseManager;

public class RestaurantDB extends DatabaseManager<Restaurant> {

    //restoranın adına göre daha önce eklenip eklenmediğini kontrol ediyoruz.
    public boolean isRestaurantExist(String restaurantName){
        for (Restaurant item: arrayList){
            if(item.getName().equalsIgnoreCase(restaurantName)) {
                return true;
            }
        }
        return false;
    }

    public Restaurant findByRestaurantName(String name){
        for (Restaurant restaurant: arrayList){
            if(restaurant.getName().equalsIgnoreCase(name)){
                return restaurant;
            }
        }
        return null;
    }


}
