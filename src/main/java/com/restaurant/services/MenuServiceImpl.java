package com.restaurant.services;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restaurant.dao.RestaurantDao;
import com.restaurant.domain.FoodItem;

@Component
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private RestaurantDao restaurantDao;

	@Override
	public List<FoodItem> getMenu() {
		
		/*final FoodItem footdItem = new FoodItem("Chicken Curry", Arrays.asList("Chicken Curry","Tomatoes","Onions"), new BigDecimal("10.00"));
		final FoodItem footdItem2 = new FoodItem("Chicken Fried rice", Arrays.asList("Chicken","Rice"), new BigDecimal("12.00"));
		final FoodItem footdItem3 = new FoodItem("Chicken Noodles", Arrays.asList("Chicken","Noodles"), new BigDecimal("10.00"));
		
		return Arrays.asList(footdItem,footdItem2, footdItem3);*/
		return restaurantDao.getAll(); 
	}

	@Override
	public FoodItem getSpecialOfTheDay(String dayOfWeek) {
		return restaurantDao.getFoodItem(new Random().nextInt(3)+1);
	}	

}
