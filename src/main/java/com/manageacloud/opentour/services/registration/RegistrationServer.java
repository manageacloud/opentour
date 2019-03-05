package com.manageacloud.opentour.services.registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * All you need to run a Eureka registration server.
 * 
 * @author Ruben Rubio
 */
@EnableWebSecurity
@SpringBootApplication
@EnableEurekaServer
public class RegistrationServer {

	/**
	 * Run the application using Spring Boot and an embedded servlet engine.
	 * 
	 * @param args
	 *            Program arguments - ignored.
	 */
	public static void main(String[] args) {
		// Tell server to look for registration.properties or registration.yml
		System.setProperty("spring.config.name", "registration-server");

		SpringApplication.run(RegistrationServer.class, args);
	}
}
