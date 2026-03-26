package com.nougat.authentication.services;

import com.nougat.application.dto.users.UserSummaryDTO;
import com.nougat.application.usecases.users.commands.CreateUserCommand;
import com.nougat.authentication.dto.request.LoginRequest;
import com.nougat.authentication.dto.response.LoginResponse;
import com.nougat.authentication.dto.response.RegisterResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    CreateUserCommand command;

    public AuthService(AuthenticationManager authenticationManager,
                       JwtService jwtService,
                       PasswordEncoder passwordEncoder,
                       CreateUserCommand command) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.command = command;
    }

    public LoginResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );

        String token = jwtService.generateToken(request.email());
        return new LoginResponse(token);
    }

    public RegisterResponse register(UserSummaryDTO request) {
        request.setPasswordHash(passwordEncoder.encode(request.getPasswordHash()));
        command.handler(request);
        return new RegisterResponse("User registered successfully");
    }
}
