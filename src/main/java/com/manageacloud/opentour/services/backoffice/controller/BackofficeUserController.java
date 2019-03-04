package com.manageacloud.opentour.services.backoffice.controller;

import com.manageacloud.opentour.services.backoffice.gateway.BackofficeUserGateway;
import com.manageacloud.opentour.users.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.logging.Logger;

/**
 * Client controller, fetches Account info from the microservice via
 * {@link BackofficeUserGateway }.
 * 
 * @author Ruben Rubio
 */
@Controller
public class BackofficeUserController {

	@Autowired
	protected BackofficeUserGateway usersService;

	protected Logger logger = Logger.getLogger(BackofficeUserController.class
			.getName());

	public BackofficeUserController(BackofficeUserGateway usersService) {
		this.usersService = usersService;
	}

	@RequestMapping("/user/{email}")
	public String byEmail(Model model,
			@PathVariable("email") String email) {

		logger.info("web-service byEmail() invoked: " + email);
		User user = usersService.findByEmail(email);
		logger.info("web-service byEmail() found: " + user);
		model.addAttribute("user", user);
		return "user";
	}


}
