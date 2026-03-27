package com.nougat.api.controllers;

import com.nougat.application.dto.products.ProductSummaryDto;
import com.nougat.application.dto.users.UserSummaryDTO;
import com.nougat.application.usecases.users.commands.CreateUserCommand;
import com.nougat.domain.repository.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users")
@Tag(name = "Users", description = "Users API")
public class UserController {

    private final CreateUserCommand create;

    public UserController(CreateUserCommand create) { this.create = create; }

    @PostMapping("register")
    @Operation(summary = "register an user")
    public void registerUser(@RequestBody UserSummaryDTO user) {
        create.handler(user);
    }
}
