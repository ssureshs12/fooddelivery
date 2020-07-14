package com.restapi.fooddelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restapi.fooddelivery.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
