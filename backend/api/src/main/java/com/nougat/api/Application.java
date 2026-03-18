package com.nougat.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.nougat.domain")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
