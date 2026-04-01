package com.nougat.authentication.services;

import com.nougat.application.dto.login.LogInDto;
import com.nougat.application.dto.users.UserSummaryDTO;
import com.nougat.application.usecases.users.commands.CreateUserCommand;
import com.nougat.application.usecases.users.queries.GetUserByEmail.GetUserByEmailQuery;
import com.nougat.authentication.dto.response.LoginResponse;
import com.nougat.authentication.dto.response.RegisterResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class AuthService {

    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    CreateUserCommand command;
    GetUserByEmailQuery getUserByEmailQuery;

    public AuthService(JwtService jwtService,
                       PasswordEncoder passwordEncoder,
                       CreateUserCommand command,
                       GetUserByEmailQuery getUserByEmailQuery) {
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.command = command;
        this.getUserByEmailQuery = getUserByEmailQuery;
    }

    public LoginResponse login(LogInDto request) {
        try {
            String token = jwtService.generateToken(request.getEmail());
            return new LoginResponse(token);
        }
        catch (Exception e) {
            return new LoginResponse("There was an error " + e.getMessage());
        }
    }

    public RegisterResponse register(UserSummaryDTO request) {
        try {
            Logger l = LoggerFactory.getLogger(AuthService.class);
            request.setPasswordHash(passwordEncoder.encode(request.getPasswordHash()));
            l.info("Password hash: " + request.getPasswordHash());

            command.handler(request);
            return new RegisterResponse("User registered successfully");
        }
        catch (Exception e) {
            return new RegisterResponse("There was an error " + e.getMessage());
        }
    }
}
