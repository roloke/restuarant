package com.restaurant.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.restaurant.domain.FoodItem;
import com.restaurant.domain.Order;
import com.restaurant.services.OrderService;


@Path("order") 
@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response orderItem(List<FoodItem> foodItems) {
		return Response.status(Response.Status.CREATED)
				.entity(orderService.placeOrder(foodItems)).build();
	}

	@PUT
	@Path("/{orderNo}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON) 
	public Response updateOrder(@PathParam("orderNo")String orderNo, List<FoodItem> foodItems) {
		orderService.updateOrder(orderNo, foodItems);
		return Response.status(Response.Status.OK)
				.entity(orderNo).build();
	}
	
	@GET
	@Path("/bill/{orderNo}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBill(@PathParam("orderNo")String orderNo) {
		final Order order = orderService.getBill(orderNo);
		System.out.println(order);
		if(order != null) {
			return Response.status(Response.Status.OK)
					.entity(order).build();
		} else {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity(orderNo + " is not correct order number.").build();
		}
	}
}
