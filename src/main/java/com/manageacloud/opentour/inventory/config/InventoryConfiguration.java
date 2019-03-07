package com.manageacloud.opentour.inventory.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
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
@PropertySource("classpath:services/inventory/db-config-inventory.properties")
public class InventoryConfiguration {

    protected Logger logger;

    public InventoryConfiguration() {
        logger = Logger.getLogger(getClass().getName());
    }


}
