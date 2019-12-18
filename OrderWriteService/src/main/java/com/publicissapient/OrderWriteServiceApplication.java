package com.publicissapient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
//@EnableDiscoveryClient
@SpringBootApplication
@EnableCircuitBreaker
public class OrderWriteServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderWriteServiceApplication.class, args);
	}

}
