package com.restaurant.services;

import java.util.List;

import com.restaurant.domain.FoodItem;

 
public interface MenuService {

	public List<FoodItem> getMenu();
	
	public FoodItem getSpecialOfTheDay(String dayOfWeek);  

}
