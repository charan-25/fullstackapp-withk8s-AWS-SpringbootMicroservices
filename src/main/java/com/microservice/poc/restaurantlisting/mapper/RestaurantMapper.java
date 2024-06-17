package com.microservice.poc.restaurantlisting.mapper;

import com.microservice.poc.restaurantlisting.dtos.RestaurantDto;
import com.microservice.poc.restaurantlisting.entities.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestaurantMapper {
    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);

    Restaurant mapRestauarantDtoToRestaurant(RestaurantDto dto);
    RestaurantDto mapRestaurantToRestaurantDto(Restaurant restaurant);
}
