package com.restapi.fooddelivery.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "food")
@EntityListeners(AuditingEntityListener.class)
public class Food {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long foodID;
	
	@Column(name = "foodName", nullable = false)
	private String foodName;
	
	@Column(name = "restaurantId", nullable = false)
	private int restaurantId;
	
	@Column(name = "restaurantName", nullable = false)
	private String restaurantName;
	
	@Column(name = "ratings", nullable = false)
	private int ratings;
	
	@Column(name = "price", nullable = false)
	private int price;
	
	public Long getFoodID() {
		return foodID;
	}

	public void setFoodID(Long foodID) {
		this.foodID = foodID;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public int getRatings() {
		return ratings;
	}

	public void setRatings(int ratings) {
		this.ratings = ratings;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	

}
