package com.restaurant.dao;

import java.util.List;

import com.restaurant.domain.FoodItem;
import com.restaurant.domain.Order;

public interface RestaurantDao {
	void save(Order entity);
	List<FoodItem> getAll();
	void delete(Order entity);
	FoodItem getFoodItem(long id);
	Order getOrder(String orderNo);
}
