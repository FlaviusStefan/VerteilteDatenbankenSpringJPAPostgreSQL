package com.simpleform.simpleform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.simpleform.simpleform.model")
public class SimpleFormApplication {
	public static void main(String[] args) {
		SpringApplication.run(SimpleFormApplication.class, args);
	}
}