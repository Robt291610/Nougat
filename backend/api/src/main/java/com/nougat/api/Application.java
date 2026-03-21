package com.nougat.api;

import com.nougat.api.controllers.UserController;
import com.nougat.application.usecases.users.commands.CreateUserCommand;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.nougat.domain")
@ComponentScan(basePackages = "com.nougat")
@EnableJpaRepositories(basePackages = "com.nougat.infrastructure.persistence.repositories")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
