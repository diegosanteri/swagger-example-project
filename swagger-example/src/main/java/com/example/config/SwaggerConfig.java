package com.example.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.collect.Sets;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {            
		
	    return new Docket(DocumentationType.SWAGGER_2)       
	      .host("localhost:8080")	
	      .protocols(Sets.newHashSet("http"))
	      .select()                                       
	      .apis(RequestHandlerSelectors.basePackage("com.example.controller"))
	      .paths(PathSelectors.ant("/api/**"))                     
	      .build()
	      .apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
	     return new ApiInfo(
	       "Petstore API", 
	       "This API is responsible to handle pet data.", 
	       "1.0", 
	       "Terms of service", 
	       new Contact("diegosanteri", "www.example.com", "diegosanteri@gmail.com"), 
	       "License of API", "MTI", Collections.emptyList());
	}
}
