package com.restaurant.domain;

import java.math.BigDecimal;
import java.util.List;

public class Order {

	//orm
	private long id;
	private long version;
	
	//object attributes
	private String orderNo;
	private List<FoodItem> foodItems;
	private BigDecimal totalAmount;
	
	public long getId() {
		return id;
	}
	public long getVersion() {
		return version;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public List<FoodItem> getFoodItems() {
		return foodItems;
	}
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	
	
	
	
}
