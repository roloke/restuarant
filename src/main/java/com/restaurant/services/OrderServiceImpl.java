package com.restaurant.services;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restaurant.domain.FoodItem;
import com.restaurant.domain.Order;


@Component
public class OrderServiceImpl implements OrderService {

	private final Map<String, Order> orders = new HashMap<>();
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Override
	public String placeOrder(final List<FoodItem> foodItems) {
		final Order order = new Order();
		order.setOrderNo(Long.toString(new Date().getTime()));
		order.setFoodItems(foodItems);
		rabbitTemplate.convertAndSend("kitchen",order);
		orders.put(order.getOrderNo(), order);
		return order.getOrderNo();
	}
	
	@Override
	public void updateOrder(final String orderNo, final List<FoodItem> foodItems) {
		orders.get(orderNo).getFoodItems().addAll(foodItems);
	}

	public Order getBill(final String orderNo) {
		return orders.get(orderNo);
	}
}
