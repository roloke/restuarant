package com.restaurant.services;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.restaurant.domain.FoodItem;

@Component
public class MenuServiceImpl implements MenuService {

	@Override
	public List<FoodItem> getMenu() {
		
		final FoodItem footdItem = new FoodItem("Chicken Curry", Arrays.asList("Chicken Curry","Tomatoes","Onions"), new BigDecimal("10.00"));
		final FoodItem footdItem2 = new FoodItem("Chicken  Fried rice", Arrays.asList("Chicken","Rice"), new BigDecimal("12.00"));
		final FoodItem footdItem3 = new FoodItem("Chicken Noodles", Arrays.asList("Chicken","Noodles"), new BigDecimal("10.00"));
		
		return Arrays.asList(footdItem,footdItem2, footdItem3);
	}

	@Override
	public FoodItem getSpecialOfTheDay(String dayOfWeek) {
		final String name = "'s special Chicken";
		
		return new FoodItem(dayOfWeek + name, Arrays.asList("Chicken Curry","Tomatoes","Onions"), new BigDecimal("10.00"));
	}	

}
