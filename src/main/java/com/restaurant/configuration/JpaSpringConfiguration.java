package com.restaurant.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

@Configuration
@EnableTransactionManagement
public class JpaSpringConfiguration {
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setJtaDataSource(dataSource());
		em.setPackagesToScan("com.restaurant.domain");
		final HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setShowSql(true);
		jpaVendorAdapter.setGenerateDdl(false);
		em.setJpaVendorAdapter(jpaVendorAdapter);
		//em.setPersistenceProvider(persistenceProvider);  Class(org.hibernate.jpa.HibernatePersistenceProvider.class);
		final Properties props = new Properties();
        props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        props.setProperty("hibernate.format_sql", "true");
        props.setProperty("hibernate.validator.apply_to_ddl", "false");
        props.setProperty("hibernate.validator.autoregister_listeners", "false");        
        props.setProperty("hibernate.transaction.jta.platform","org.hibernate.service.jta.platform.internal.JBossAppServerJtaPlatform");
		em.setJpaProperties(props);
		
		return em;
	}
	
	@Bean
	public PlatformTransactionManager platformTransactionManager(){ 
	    return new JtaTransactionManager();
	}
	
	@Bean
	public DataSource dataSource() {
		JndiDataSourceLookup jndiLookup = new JndiDataSourceLookup();
		//jndiLookup.setResourceRef(true);
		return jndiLookup.getDataSource("java:jboss/datasource/restaurantDS");
	}

}
