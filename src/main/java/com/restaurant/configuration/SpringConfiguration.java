package com.restaurant.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.restaurant.controller", "com.restaurant.services"})
public class SpringConfiguration {

	
}
