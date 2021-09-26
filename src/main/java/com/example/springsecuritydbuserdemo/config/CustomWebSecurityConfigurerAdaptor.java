package com.example.springsecuritydbuserdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
public class CustomWebSecurityConfigurerAdaptor extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic(); // you need to explicitly define the authentication
        // as http basic in case you are overriding UserDetailService
        http.authorizeRequests().mvcMatchers("**/secure/**").authenticated().and()
                .authorizeRequests().mvcMatchers("**/public/**").permitAll();
    }

}
