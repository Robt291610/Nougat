package com.nougat.authentication.services;

import com.nougat.application.dto.users.ByEmail;
import com.nougat.application.dto.users.UserSummaryDTO;
import com.nougat.application.usecases.users.commands.CreateUserCommand;
import com.nougat.application.usecases.users.queries.GetUserByEmail.GetUserByEmailQuery;
import com.nougat.authentication.dto.request.LoginRequest;
import com.nougat.authentication.dto.response.LoginResponse;
import com.nougat.authentication.dto.response.RegisterResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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

    public LoginResponse login(LoginRequest request) {
        try {
//            if( request.email() == null){
//                return new LoginResponse("The user cannot be null");
//            }
            String token = jwtService.generateToken(request.email());
            return new LoginResponse(token);
        }
        catch (Exception e) {
            return new LoginResponse("There was an error " + e.getMessage());
        }
    }

    public RegisterResponse register(UserSummaryDTO request) {
        try {
            if(getUserByEmailQuery.handle(request.getEmail()) != null){
                return new RegisterResponse("The user already exists");
            }
            request.setPasswordHash(passwordEncoder.encode(request.getPasswordHash()));
            command.handler(request);
            return new RegisterResponse("User registered successfully");
        }
        catch (Exception e) {
            return new RegisterResponse("There was an error " + e.getMessage());
        }
    }
}
