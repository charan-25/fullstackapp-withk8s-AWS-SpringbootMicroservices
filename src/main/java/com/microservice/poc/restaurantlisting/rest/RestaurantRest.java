package com.microservice.poc.restaurantlisting.rest;

import com.microservice.poc.restaurantlisting.dtos.RestaurantDto;
import com.microservice.poc.restaurantlisting.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantRest {
    @Autowired
    private RestaurantService service;

    @GetMapping("/fetchAllRestaurants")
    public ResponseEntity<List<RestaurantDto>> getAllRestaurants(){
        List<RestaurantDto> allRestaurants = service.getAllRestaurants();
        return new ResponseEntity<>(allRestaurants, HttpStatus.OK);
    }

    @PostMapping("/addRestaurant")
    public ResponseEntity<RestaurantDto> addRestaurant(@RequestBody RestaurantDto dto){
        RestaurantDto restaurantDto = service.addRestaurant(dto);
        return new ResponseEntity<>(restaurantDto,HttpStatus.CREATED);
    }

    @GetMapping("/fetchById/{id}")
    public ResponseEntity<RestaurantDto> fetchRestaurantById(@PathVariable Integer id){
        return service.fetchRestaurantById(id);
    }
}
