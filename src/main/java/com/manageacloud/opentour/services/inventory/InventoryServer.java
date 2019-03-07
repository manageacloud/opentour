package com.manageacloud.opentour.services.inventory;

import com.manageacloud.opentour.inventory.config.InventoryConfiguration;
import com.manageacloud.opentour.inventory.service.InventoryService;
import com.manageacloud.opentour.users.config.UserConfiguration;
import com.manageacloud.opentour.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import java.util.logging.Logger;

/**
 * Run as a micro-service, registering with the Discovery Server (Eureka).
 * <p>
 * Note that the configuration for this application is imported from
 * {@link UserConfiguration}. This is a deliberate separation of concerns.
 * <p>
 * This class declares no beans and current package contains no components for
 * ComponentScan to find. No point using <tt>@SptingBootApplication</tt>.
 * 
 * @author Ruben Rubio
 */
@EnableAutoConfiguration
@EnableWebSecurity
@EnableDiscoveryClient
@Import(InventoryConfiguration.class)
public class InventoryServer {

	@Autowired
	protected InventoryService inventoryService;

	protected Logger logger = Logger.getLogger(InventoryServer.class.getName());

	/**
	 * Run the application using Spring Boot and an embedded servlet engine.
	 * 
	 * @param args
	 *            Program arguments - ignored.
	 */
	public static void main(String[] args) {
		// Tell server to look for accounts-server.properties or
		// accounts-server.yml
		System.setProperty("spring.config.name", "inventory-server");

		SpringApplication.run(InventoryServer.class, args);
	}
}
