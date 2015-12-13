package com.restaurant.configuration;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@EnableRabbit
@ComponentScan({"com.restaurant.controller", "com.restaurant.services", "com.restaurant.dao"})
@Import({JpaSpringConfiguration.class, RabbitMQSpringConfiguration.class})
public class SpringConfiguration {

	@Bean
	public PropertyPlaceholderConfigurer propertyPlaceHolder() {
		return new PropertyPlaceholderConfigurer(); 
	}	
}
