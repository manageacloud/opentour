package com.manageacloud.opentour.users.controller;

import com.manageacloud.opentour.exceptions.NotFoundException;
import com.manageacloud.opentour.users.model.User;
import com.manageacloud.opentour.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

/**
 * A RESTFul controller for accessing user information.
 * 
 * @author Ruben Rubio
 */
@RestController
public class UserController {

	protected Logger logger = Logger.getLogger(UserController.class
			.getName());
	protected UserRepository userRepository;

	/**
	 * Create an instance plugging in the respository of Users
	 *
	 * @param userRepository
	 *            User repository implementation.
	 */
	@Autowired
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	/**
	 * Fetch if the user exists
	 *
	 * @param userEmail
	 * @return
	 */
	@RequestMapping("/user/{email}")
	public User byEmail(@PathVariable("email") String userEmail) {

		logger.info("user-service by Password invoked: " + userEmail);
		userRepository.findByEmailIgnoreCaseContaining(userEmail);
		List<User> users = userRepository.findByEmailIgnoreCaseContaining(userEmail);

		if ( users.size() != 1  ) {
			throw new NotFoundException(String.format("Email %s not found", userEmail));
		} else {
			return users.get(0);
		}
	}


}
