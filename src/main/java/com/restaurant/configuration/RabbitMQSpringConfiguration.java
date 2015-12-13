package com.restaurant.configuration;

import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class RabbitMQSpringConfiguration {
	
	@Autowired
	private PlatformTransactionManager platformTransactionManager; 
	
	@Bean
	public ConnectionFactory rabbitConnectionFactory(@Value("${rabbitmq.host}") final String host,
			@Value("${rabbitmq.username}") final String userName, @Value("${rabbitmq.password}")final String password,
			@Value("${rabbitq.virtualhost}")final String virtualHost ){
		
		final CachingConnectionFactory cachingConnectionFactory= new CachingConnectionFactory();
		cachingConnectionFactory.setHost(host);
		cachingConnectionFactory.setUsername(userName);
		cachingConnectionFactory.setPassword(password);
		cachingConnectionFactory.setVirtualHost(virtualHost);
		return cachingConnectionFactory;
	}
	
	@Bean
	public RabbitAdmin rabbitAdmin(final ConnectionFactory connectionFactory, final ApplicationContext applicationContext) {
		final RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
		rabbitAdmin.setApplicationContext(applicationContext);
		rabbitAdmin.initialize();
		return rabbitAdmin; 
	}
	
	@Bean
	public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory, final MessageConverter messageConverter) {
		final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.setMessageConverter(messageConverter);
		rabbitTemplate.setChannelTransacted(true);
		
		return rabbitTemplate;
	}
	
	@Bean
	public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(final ConnectionFactory connectionFactory,
			final MessageConverter messageConverter) {
		final SimpleRabbitListenerContainerFactory containerFactory = new SimpleRabbitListenerContainerFactory();
		containerFactory.setConnectionFactory(connectionFactory);
		containerFactory.setConcurrentConsumers(1);
		containerFactory.setMaxConcurrentConsumers(5);
		containerFactory.setMessageConverter(messageConverter);
		containerFactory.setChannelTransacted(true);
		//containerFactory.setTransactionManager(platformTransactionManager);
		return containerFactory;
	}
	
	
	@Bean
	public MessageConverter rabbitJacksonConverter() {
		return new Jackson2JsonMessageConverter();
	}

}
