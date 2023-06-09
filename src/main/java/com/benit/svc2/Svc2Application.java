package com.benit.svc2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class Svc2Application {

	public static void main(String[] args) {
		SpringApplication.run(Svc2Application.class, args);
	}

}
