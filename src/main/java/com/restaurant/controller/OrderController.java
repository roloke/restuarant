package com.restaurant.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;



@Component
@Path("welcome") 
public class OrderController {

	@GET
	//@Path("welcome")
	@Produces(MediaType.TEXT_PLAIN)
	public String welcome() {
		return "welcome to retuarant";
	}
	
}
