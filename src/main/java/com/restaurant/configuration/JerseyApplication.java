package com.restaurant.configuration;


import org.glassfish.jersey.server.ResourceConfig;


public class JerseyApplication extends ResourceConfig {
	public JerseyApplication() {
		packages("com.restaurant.controller");
	}
	

}
