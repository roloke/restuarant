package com.restaurant.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.restaurant.controller", "com.restaurant.domain"})
public class SpringConfiguration {

	
}
