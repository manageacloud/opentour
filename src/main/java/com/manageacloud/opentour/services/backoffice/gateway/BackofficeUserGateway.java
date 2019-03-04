package com.manageacloud.opentour.services.backoffice.gateway;

import com.manageacloud.opentour.users.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.logging.Logger;

/**
 * Hide the access to the microservice inside this local service.
 * 
 * @author Ruben Rubio
 */
@Service
public class BackofficeUserGateway {

	@Autowired
	@LoadBalanced
	protected RestTemplate restTemplate;

	protected String serviceUrl;

	protected Logger logger = Logger.getLogger(BackofficeUserGateway.class
			.getName());

	public BackofficeUserGateway(String serviceUrl) {
		this.serviceUrl = serviceUrl.startsWith("http") ? serviceUrl
				: "http://" + serviceUrl;
	}


	public User findByEmail(String email) {

		logger.info("findByEmail() invoked: for " + email);
		return restTemplate.getForObject(serviceUrl + "/user/{email}",
				User.class, email);


	}


}
