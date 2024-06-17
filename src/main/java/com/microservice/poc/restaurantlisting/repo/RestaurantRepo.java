package com.microservice.poc.restaurantlisting.repo;

import com.microservice.poc.restaurantlisting.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepo extends JpaRepository<Restaurant,Integer> {
}
