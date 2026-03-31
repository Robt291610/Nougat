package com.nougat.api.controllers;

import com.nougat.application.dto.users.UserSummaryDTO;
import com.nougat.application.usecases.users.queries.GetUserById.GetUserByIdQuery;
import com.nougat.application.usecases.users.queries.findAllUsers.FindAllUsersQuery;
import com.nougat.domain.entities.User;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/user")
public class UserController {

    private final GetUserByIdQuery query;
    private final FindAllUsersQuery findAllUsersQuery;

    public UserController(GetUserByIdQuery query, FindAllUsersQuery findAllUsersQuery) {
        this.query = query;
        this.findAllUsersQuery = findAllUsersQuery;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get an user by id")
    public UserSummaryDTO getUser(@PathVariable UUID id) {
        return query.handle(id);
    }

    @GetMapping
    @Operation(summary = "Get all users")
    public List<UserSummaryDTO> getUsers() {
        return findAllUsersQuery.handle();
    }
}
