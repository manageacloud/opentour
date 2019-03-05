package com.manageacloud.opentour.services.users.config;

import com.manageacloud.opentour.services.backoffice.controller.BackofficeUserController;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.util.logging.Logger;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    protected Logger logger = Logger.getLogger(BackofficeUserController.class
            .getName());

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/**").permitAll();
        http.csrf().disable();
    }
}