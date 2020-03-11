package com.accenture.sabyasachi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringbootH2IntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootH2IntegrationApplication.class, args);
	}

}
