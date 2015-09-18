package com.restaurant.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.restaurant.domain.FoodItem;

@Component
public class MenuServiceImpl implements MenuService {

	@Override
	public List<FoodItem> getMenu() {
		
		return null;
	}

	@Override
	public List<FoodItem> getSpecialOfTheDay(String dayOfWeek) {
		return null;
	}		
}
