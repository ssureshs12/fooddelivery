package com.restapi.fooddelivery.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.fooddelivery.model.Order;
import com.restapi.fooddelivery.exceptions.ResourceNotFoundException;
import com.restapi.fooddelivery.model.Food;
import com.restapi.fooddelivery.repository.OrderRepository;
import com.restapi.fooddelivery.repository.FoodRepository;


@RestController
@RequestMapping("/food")
public class FoodController {
	
	@Autowired
	private FoodRepository foodRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@GetMapping("/foodList")
	public List<Food> getAllFoods() {
		return foodRepository.findAll();
	}
	
	@PostMapping("/foods")
	public Food createFood(@Validated @RequestBody Food food) {
		return foodRepository.save(food);
	}
	
	 @GetMapping("/foods/{id}")
	    public ResponseEntity<Food> getFoodById(
	    @PathVariable(value = "id") Long foodId) throws ResourceNotFoundException {
	        Food food = foodRepository.findById(foodId)
	        .orElseThrow(() -> new ResourceNotFoundException("Food not found on :: "+ foodId));
	        return ResponseEntity.ok().body(food);
	    }
	
	@PostMapping("/orderFood")
	public Order orderFood(@Validated @RequestBody Order cusomer) {
		return orderRepository.save(cusomer);
	}
	
	@PutMapping("/updateOrder/{id}")
    public ResponseEntity<Order> updateOrder(
    @PathVariable(value = "id") Long orderId,
    @Validated @RequestBody Order orderDetails) throws ResourceNotFoundException {
         Order order = orderRepository.findById(orderId)
          .orElseThrow(() -> new ResourceNotFoundException("Order not found on :: "+ orderId));
  
         order.setFoodName(orderDetails.getFoodName());
         order.setCustomerName(orderDetails.getCustomerName());
         order.setCustomerId(orderDetails.getCustomerId());
         order.setRestaurantId(orderDetails.getRestaurantId());
         order.setRestaurantName(orderDetails.getRestaurantName());
         order.setPrice(orderDetails.getPrice());
        final Order updatedOrder = orderRepository.save(order);
        return ResponseEntity.ok(updatedOrder);
   }
	
	@DeleteMapping("/deleteOrder/{id}")
	public Map<String, Boolean> deleteOrder(
       @PathVariable(value = "id") Long orderId) throws Exception {
       Order order = orderRepository.findById(orderId)
          .orElseThrow(() -> new ResourceNotFoundException("Order not found on :: "+ orderId));

       orderRepository.delete(order);
       Map<String, Boolean> response = new HashMap<>();
       response.put("deleted", Boolean.TRUE);
       return response;
	}
	
	@GetMapping("/orderList")
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}
	
	@GetMapping("/orders/{id}")
    public ResponseEntity<Order> getOrderById(
    @PathVariable(value = "id") Long orderId) throws ResourceNotFoundException {
        Order order = orderRepository.findById(orderId)
        .orElseThrow(() -> new ResourceNotFoundException("Order not found on :: "+ orderId));
        return ResponseEntity.ok().body(order);
    }

}
