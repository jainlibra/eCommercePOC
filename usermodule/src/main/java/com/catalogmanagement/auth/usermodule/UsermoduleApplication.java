package com.catalogmanagement.auth.usermodule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class UsermoduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsermoduleApplication.class, args);
	}

}
