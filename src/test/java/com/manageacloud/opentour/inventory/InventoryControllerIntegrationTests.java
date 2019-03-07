package com.manageacloud.opentour.inventory;

import com.manageacloud.opentour.config.InventoryConfigurationTests;
import com.manageacloud.opentour.config.Lang;
import com.manageacloud.opentour.inventory.config.InventoryConfiguration;
import com.manageacloud.opentour.inventory.controller.InventoryController;
import com.manageacloud.opentour.inventory.model.Item;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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
    private MockMvc mockMvc;

    @Test
    public void addItemTest() {

        String name_EN = "Test Point Of Interest";

        Item item = new Item(Lang.EN_AU, 1,name_EN);

        item = inventoryController.addInventory(item);

        assertNotNull(item.getId());
        assertEquals(item.getName(Lang.EN_AU), name_EN);
    }

    @Test
    public void addItemI18nTest() {

        String name_EN = "Test Point Of Interest";
        String name_ES = "Punto de Interes";

        String[] names = new String[Lang.size()];
        names[Lang.ES_ES.getId()] = name_ES;
        names[Lang.EN_AU.getId()] = name_EN;

        Item item = new Item(1,names);

        item = inventoryController.addInventory(item);

        assertNotNull(item.getId());
        assertEquals(item.getName(Lang.EN_AU), name_EN);
        assertEquals(item.getName(Lang.ES_ES), name_ES);
    }


}
