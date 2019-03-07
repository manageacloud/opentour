package com.manageacloud.opentour.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;
import java.util.logging.Logger;

/**
 * The user service configuraion
 *
 * @author Ruben Rubio
 */
@Configuration
@EntityScan("com.manageacloud.opentour.inventory.model")
@ComponentScan(basePackages =  {"com.manageacloud.opentour.inventory.controller", "com.manageacloud.opentour.inventory.service"})
@EnableJpaRepositories(basePackages = "com.manageacloud.opentour.inventory.repository")
@PropertySource("classpath:db-config-inventory-tests.properties")
public class InventoryConfigurationTests {

    protected Logger logger;

    @Value("${spring.datasource.schema-sql}")
    private String schemaSQL;

    @Value("${spring.datasource.data-sql}")
    private String dataSQL;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;


    public InventoryConfigurationTests() {
        logger = Logger.getLogger(getClass().getName());
    }

    /**
     * Rebuilds the test database every time the tests are executed
     */
    @Bean
    public DataSource dataSource() {


        ResourceDatabasePopulator populator = new ResourceDatabasePopulator();

        populator.addScript(new ClassPathResource(this.schemaSQL));
        populator.addScript(new ClassPathResource(this.dataSQL));

        DataSource dataSource = DataSourceBuilder.create()
                .url(this.url)
                .username(this.username)
                .build();

        DatabasePopulatorUtils.execute(populator, dataSource);

        return dataSource;
    }


}
