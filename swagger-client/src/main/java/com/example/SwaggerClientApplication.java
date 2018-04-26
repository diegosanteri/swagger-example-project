package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SwaggerClientApplication {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	} 
	
	public static void main(String[] args) {
		SpringApplication.run(SwaggerClientApplication.class, args);
	}
}
