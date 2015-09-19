package com.restaurant.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.restaurant.services.MenuService;


@Path("menu") 
@Controller
public class MenuController {

	@Autowired
	private MenuService menuService;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMenu() {
		return Response.status(Response.Status.OK)
				.entity(menuService.getMenu()).build();
	}
	
	
	@GET
	@Path("/deals/{dayOfWeek}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSpecialOfTheDay(@PathParam("dayOfWeek")String dayOfWeek) {
		return Response.status(Response.Status.OK)
				.entity(menuService.getSpecialOfTheDay(dayOfWeek)).build();
	}	
	
}
