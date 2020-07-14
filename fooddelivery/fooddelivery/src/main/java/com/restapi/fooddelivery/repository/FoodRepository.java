package com.restapi.fooddelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restapi.fooddelivery.model.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Long>{

}
