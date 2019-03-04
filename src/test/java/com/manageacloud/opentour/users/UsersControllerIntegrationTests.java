package com.manageacloud.opentour.users;

import com.manageacloud.opentour.exceptions.NotFoundException;
import com.manageacloud.opentour.users.config.UserConfiguration;
import com.manageacloud.opentour.users.controller.UserController;
import com.manageacloud.opentour.users.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.logging.Logger;

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
@SpringBootTest(classes = UserConfiguration.class, properties = { "eureka.client.enabled=false" })
public class UsersControllerIntegrationTests  {

    protected static final String USER_EMAIL = "admin@taromba.com";

    @Autowired
    UserController userController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getUserTest() {
        Logger.getGlobal().info("Start getUserTest");
        User user = userController.byEmail(USER_EMAIL);

        Assert.assertNotNull(user);
        Logger.getGlobal().info("End validAccount test " + user.toString() );
    }

    @Test
    public void userExistsTest() throws Exception {

        mockMvc.perform(get("/user/" + USER_EMAIL))
                .andExpect(status().is2xxSuccessful());

    }

    @Test
    public void userDoesNotExistsTest() throws Exception {

        mockMvc.perform(get("/user/userdoesnotexists@taromba.com/456"))
                .andExpect(status().is4xxClientError());

    }


}
