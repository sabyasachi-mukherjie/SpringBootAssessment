package com.accenture.sabyasachi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class UserListApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserListApplication.class, args);
	}

}
