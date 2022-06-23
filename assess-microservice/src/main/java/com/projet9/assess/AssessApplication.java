package com.projet9.assess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients("com.projet9")
@SpringBootApplication
public class AssessApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssessApplication.class, args);
	}

}
