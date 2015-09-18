package com.restaurant.services;

import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderingService {

	@Override
	public String placeOrder() {
		//System.out.println("placing order");
		return "placing order";
	}

}
