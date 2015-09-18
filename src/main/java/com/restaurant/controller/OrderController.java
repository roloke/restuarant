package com.restaurant.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Controller;

import com.restaurant.domain.FoodItem;


@Path("order") 
@Controller
public class OrderController {
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response orderItem(FoodItem foodItem) {
		return null;
		
	}

}
