package edu.brandeis.rseg105.spring.jdbc.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;


/**
 * @author Louis LeBlanc
 * Adapted from sources provded with Pro Spring 5
 * For Homework Assignment 1
 * Expert Software Development in Java
 * Brandeis University
 * Instructed by Vitaly Yurik
 */

@Configuration
@PropertySource("classpath:db/jdbc.properties")
@ComponentScan(basePackages = "edu.brandeis.rseg105.spring.jdbc")
public class AppConfig {

	private static Logger logger = LoggerFactory.getLogger(AppConfig.class);
	@Value("${driverClassName}")
	private String driverClassName;
	@Value("${url}")
	private String url;
	// For some strange reason, "username" behaves strangely on Linux.
	@Value("${userid}")
	private String username;
	@Value("${password}")
	private String password;

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		try {
			/* Used for debugging.
			logger.info("BasicDataSource configurations:");
			logger.info("    driverClassName: " + driverClassName);
			logger.info("    url            : " + url);
			logger.info("    userid         : " + username);
			logger.info("    password       : " + password);
			*/

			BasicDataSource dataSource = new BasicDataSource();
			dataSource.setDriverClassName(driverClassName);
			dataSource.setUrl(url);
			dataSource.setUsername(username);
			dataSource.setPassword(password);
			return dataSource;
		} catch (Exception e) {
			logger.error("DBCP DataSource bean cannot be created!", e);
			return null;
		}
	}
}
