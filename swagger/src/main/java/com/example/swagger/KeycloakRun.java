package com.example.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.example.swagger.controller")
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class KeycloakRun {

	public static void main(String[] args) {
		SpringApplication.run(KeycloakRun.class, args);
	}

	//    @Bean
	//    public RestTemplate restTemplate() {
	//        return new RestTemplate();
	//    }
	//    
	//    @Bean
	//    public KeycloakClient keycloakClient() {
	//        return new KeycloakClient();
	//    }
}
