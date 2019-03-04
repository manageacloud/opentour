package com.manageacloud.opentour.services.backoffice;

import com.manageacloud.opentour.services.backoffice.controller.BackofficeUserController;
import com.manageacloud.opentour.services.backoffice.controller.HomeController;
import com.manageacloud.opentour.services.backoffice.gateway.BackofficeUserGateway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

/**
 * Users web-server. Works as a microservice client, fetching data from the
 * Users-Service. Uses the Discovery Server (Eureka) to find the microservice.
 * 
 * @author Ruben Rubio
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(useDefaultFilters = false) // Disable component scanner
public class BackofficeServer {

	/**
	 * URL uses the logical name of account-service - upper or lower case,
	 * doesn't matter.
	 */
	public static final String USERS_SERVICE_URL = "http://USERS-SERVICE";

	/**
	 * Run the application using Spring Boot and an embedded servlet engine.
	 * 
	 * @param args
	 *            Program arguments - ignored.
	 */
	public static void main(String[] args) {
		// Tell server to look for web-server.properties or web-server.yml
		System.setProperty("spring.config.name", "backoffice-server");
		SpringApplication.run(BackofficeServer.class, args);
	}

	/**
	 * A customized RestTemplate that has the ribbon load balancer build in.
	 *
	 * @return
	 */
	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	/**
	 * The UsersService encapsulates the interaction with the micro-service.
	 * 
	 * @return A new service instance.
	 */
	@Bean
	public BackofficeUserGateway usersService() {
		return new BackofficeUserGateway(USERS_SERVICE_URL);
	}

	/**
	 * Create the controller, passing it the {@link BackofficeUserGateway} to use.
	 * 
	 * @return
	 */
	@Bean
	public BackofficeUserController accountsController() {
		return new BackofficeUserController(usersService());
	}

	@Bean
	public HomeController homeController() {
		return new HomeController();
	}
}
