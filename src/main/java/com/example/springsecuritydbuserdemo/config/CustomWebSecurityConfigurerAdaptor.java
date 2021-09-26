package com.example.springsecuritydbuserdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class CustomWebSecurityConfigurerAdaptor extends WebSecurityConfigurerAdapter {

    /**
     * This is an alternate way of configuration where we don't need to define our UserDetailService and
     *  PasswordEncoder as Bean. We can override this method and set the UserDetailService and
     *  PasswordEncoder using AuthenticationManagerBuilder.
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        UserDetails userDetails = User.withUsername("ankit").password("ankit").authorities("read").build();
        InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
        userDetailsService.createUser(userDetails);
        auth.userDetailsService(userDetailsService).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();
        http.authorizeRequests().anyRequest().authenticated();

        // http.authorizeRequests().antMatchers("**/secure/**").authenticated().and()
           //     .authorizeRequests().antMatchers("**/public/**").permitAll();
    }
}
