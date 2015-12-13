package com.restaurant.services;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restaurant.dao.RestaurantDao;
import com.restaurant.domain.FoodItem;
import com.restaurant.domain.Order;


@Component
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Autowired
	private RestaurantDao restaurantDao;
	
	@Override
	@Transactional
	public String placeOrder(final List<FoodItem> foodItems) {
		final Order order = new Order();
		order.setOrderNo(Long.toString(new Date().getTime()));
		order.setFoodItems(foodItems);
		rabbitTemplate.convertAndSend("kitchen",order);
		order.generateTotalAmount();
		restaurantDao.save(order);
		rabbitTemplate.convertAndSend("kitchen",order);
		return order.getOrderNo();
	}
	
	@Override
	@Transactional
	public void updateOrder(final String orderNo, final List<FoodItem> foodItems) {
		rabbitTemplate.convertAndSend("kitchen",foodItems);
		restaurantDao.getOrder(orderNo).getFoodItems().addAll(foodItems);		
	}

	@Transactional
	public Order getBill(final String orderNo) {
		return restaurantDao.getOrder(orderNo).generateTotalAmount();
	}
}
