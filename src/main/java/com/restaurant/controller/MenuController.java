package com.restaurant.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restaurant.domain.FoodItem;
import com.restaurant.services.OrderingService;



@Path("menu") 
public class MenuController {

	@Autowired
	private OrderingService orderService;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<FoodItem> getMenu() {
		return orderService.getMenu();
	}
	
	
	@GET
	@Path("deals")
	@Produces(MediaType.APPLICATION_JSON)
	public List<FoodItem> getDealOfTheDay(String dayOfWeek) {
		return orderService.getDealOfTheDay(String dayOfWeek);
	}
	
	
	
}
