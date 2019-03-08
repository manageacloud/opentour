package com.manageacloud.opentour.inventory;

import com.manageacloud.opentour.config.InventoryConfigurationTests;
import com.manageacloud.opentour.config.Lang;
import com.manageacloud.opentour.inventory.config.InventoryConfiguration;
import com.manageacloud.opentour.inventory.controller.InventoryController;
import com.manageacloud.opentour.inventory.model.Item;
import com.manageacloud.opentour.inventory.model.ItemType;
import com.manageacloud.opentour.inventory.model.Region;
import com.manageacloud.opentour.inventory.model.dto.ItemDTO;
import com.manageacloud.opentour.inventory.repository.ItemTypeRepository;
import com.manageacloud.opentour.services.inventory.InventoryServer;
import com.manageacloud.opentour.users.config.UserConfiguration;
import com.manageacloud.opentour.users.controller.UserController;
import com.manageacloud.opentour.users.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.logging.Logger;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Spring Integration/System test - by using @SpringApplicationConfiguration
 * instead of @ContextConfiguration, it picks up the same configuration that
 * Spring Boot would use.
 * <p>
 * Note 1: Client discovery disabled
 *
 * @author Ruben Rubio
 */

@RunWith(SpringRunner.class)
@EnableAutoConfiguration
@AutoConfigureMockMvc
@SpringBootTest(classes = InventoryConfigurationTests.class, properties = { "eureka.client.enabled=false" })
//@SqlGroup({
//        @Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:beforeTestRun.sql"),
//        @Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:afterTestRun.sql") })
public class InventoryControllerIntegrationTests {

    protected Logger logger = Logger.getLogger(InventoryServer.class.getName());

    @Autowired
    InventoryController inventoryController;

    @Autowired
    ItemTypeRepository itemTypeRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void addItemTest() {

        String name_EN = "Test Point Of Interest";

        ItemDTO itemDTO = new ItemDTO(Lang.EN_AU.getId(), 1, name_EN,
                ItemType.TYPE.POINT_OF_INTEREST.toString(), 1L);

        Item item = inventoryController.addInventory(itemDTO);

        assertNotNull(item.getId());
        assertEquals(item.getName(Lang.EN_AU), name_EN);
        assertNull(item.getName(Lang.ES_ES));
        assertEquals(item.getItemType().getId(), ItemType.TYPE.POINT_OF_INTEREST.getId(), 0);
        assertEquals(item.getRegion().getId(), Region.Regions.SPAIN.getId(), 0);
    }




}
