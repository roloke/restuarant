package com.restaurant.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restaurant.services.OrderingService;



@Path("welcome") 
public class OrderController {

	@Autowired
	private OrderingService orderService;
	
	@GET
	//@Path("welcome")
	@Produces(MediaType.TEXT_PLAIN)
	public String welcome() {
		return orderService.placeOrder();
	}
	
}
