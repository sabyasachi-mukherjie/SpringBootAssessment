package com.accenture.sabyasachi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/*Sabyasachi*/
@EnableEurekaServer
@SpringBootApplication
public class H2BootServer {

	public static void main(String[] args) {
		SpringApplication.run(H2BootServer.class, args);
	}

}
