package com.example.springsecuritydbuserdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@Configuration
public class SpringSecurityConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public UserDetailsService userDetailsService() {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery("select username, password, enabled from users where username = ?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select username, authority from authorities where username=?");
        return jdbcUserDetailsManager;
    }

   /* @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder passwordEncoder = NoOpPasswordEncoder.getInstance();
        return passwordEncoder;
    }*/

    /**
     * This implementation of password encoder, delegate the password validation to PasswordEncoder
     * Implemenation on the basis of prefix in Hash Password.
     * {noop} - Delegate to NoOpPasswordEncoder.
     * {bcrypt} - Delegate to BCryptPasswordEncoder.
     * {scrypt} - Delegate to SCryptPasswordEncoder.
     * etc.
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoderDelegation(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
