package com.example.greeter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class GreeterApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreeterApplication.class, args);
	}
}
