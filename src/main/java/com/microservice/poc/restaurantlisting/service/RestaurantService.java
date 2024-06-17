package com.microservice.poc.restaurantlisting.service;

import com.microservice.poc.restaurantlisting.dtos.RestaurantDto;
import com.microservice.poc.restaurantlisting.entities.Restaurant;
import com.microservice.poc.restaurantlisting.mapper.RestaurantMapper;
import com.microservice.poc.restaurantlisting.repo.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepo repo;

    public List<RestaurantDto> getAllRestaurants(){
        List<Restaurant> list = repo.findAll();
        return list.stream().map(restaurant -> RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDto(restaurant)).collect(Collectors.toList());
    }

    public RestaurantDto addRestaurant(RestaurantDto dto) {
        Restaurant savedRestaurant = repo.save(RestaurantMapper.INSTANCE.mapRestauarantDtoToRestaurant(dto));
        return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDto(savedRestaurant);
    }

    public ResponseEntity<RestaurantDto> fetchRestaurantById(Integer id) {
        Optional<Restaurant> restaurantById = repo.findById(id);
        if(restaurantById.isPresent()) return new ResponseEntity<>(RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDto(restaurantById.get()), HttpStatus.OK);
        else return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
}
