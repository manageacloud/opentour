package com.manageacloud.opentour.users.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import javax.sql.DataSource;
import java.util.logging.Logger;

/**
 * The user service configuraion
 *
 * @author Ruben Rubio
 */
@Configuration
@EntityScan("com.manageacloud.opentour.users.model")
@ComponentScan("com.manageacloud.opentour.users.controller")
@EnableJpaRepositories(basePackages = "com.manageacloud.opentour.users.repository")
@PropertySource("classpath:services/users/db-config-users.properties")
public class UserConfiguration {

    protected Logger logger;

    public UserConfiguration() {
        logger = Logger.getLogger(getClass().getName());
    }


    @Bean
    public DataSource dataSource() {
        logger.info("dataSource() invoked");

        // Create an in-memory H2 relational database containing some demo
        // accounts.
        DataSource dataSource = (new EmbeddedDatabaseBuilder())
                .addScript("classpath:services/users/users-schema.sql")
                .addScript("classpath:services/users/users-data.sql").build();

        logger.info("dataSource = " + dataSource);

        return dataSource;
    }
}
