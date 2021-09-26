package com.example.springsecuritydbuserdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class SpringSecurityDbuserDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityDbuserDemoApplication.class, args);
	}

}
