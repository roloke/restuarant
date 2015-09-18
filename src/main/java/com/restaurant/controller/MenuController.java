package com.restaurant.controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.restaurant.domain.FoodItem;
import com.restaurant.services.MenuService;



@Path("menu") 
@Controller
public class MenuController {

	@Autowired
	private MenuService menuService;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<FoodItem> getMenu() {
		return menuService.getMenu();
	}
	
	
	@GET
	@Path("/deals/{dayOfWeek}")
	@Produces(MediaType.APPLICATION_JSON)
	public FoodItem getSpecialOfTheDay(@PathParam("dayOfWeek")String dayOfWeek) {
		return menuService.getSpecialOfTheDay(dayOfWeek);
	}	
	
}
