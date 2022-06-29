package com.frontend.frontendMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients("com.frontend")
@SpringBootApplication
public class FrontendMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrontendMicroserviceApplication.class, args);
	}

}
