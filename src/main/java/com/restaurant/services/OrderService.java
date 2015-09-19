package com.restaurant.services;

import java.util.List;

import com.restaurant.domain.FoodItem;
import com.restaurant.domain.Order;

public interface OrderService {
	public String placeOrder(final List<FoodItem> foodItems);
	public void updateOrder(final String orderNo, final List<FoodItem> foodItems);
	public Order getBill(final String orderNo);
}
