package com.restaurant.jersey;


import org.glassfish.jersey.server.ResourceConfig;


public class JerseyApplication extends ResourceConfig {
	public JerseyApplication() {
		register(com.restaurant.controller.OrderController.class);
		packages("com.restaurant.controller");
	}
	

}
