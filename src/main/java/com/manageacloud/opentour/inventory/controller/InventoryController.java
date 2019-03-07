package com.manageacloud.opentour.inventory.controller;

import com.manageacloud.opentour.config.Lang;
import com.manageacloud.opentour.exceptions.NotFoundException;
import com.manageacloud.opentour.inventory.model.Item;
import com.manageacloud.opentour.inventory.service.InventoryService;
import com.manageacloud.opentour.users.model.User;
import com.manageacloud.opentour.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

/**
 * A RESTFul controller for accessing user information.
 * 
 * @author Ruben Rubio
 */
@RestController
public class InventoryController {

	protected Logger logger = Logger.getLogger(InventoryController.class
			.getName());
	protected InventoryService inventoryService;

	/**
	 * Create an instance plugging in the respository of Users
	 *
	 * @param inventoryService
	 *            User repository implementation.
	 */
	@Autowired
	public InventoryController(InventoryService inventoryService) {
		this.inventoryService= inventoryService;
	}

	/**
	 * Create Inventory
	 *
	 * @param newItem new item to be inserted
	 * @return
	 */
	@PostMapping("/inventory/")
	public Item addInventory(@RequestBody Item newItem) {

		logger.info("inventory-service add inventory");
		//newItem = inventoryService.addItem(Lang.EN_AU, newItem);
		inventoryService.addItem(newItem);

		return newItem;
	}


}
