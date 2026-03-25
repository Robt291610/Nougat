package com.nougat.authentication.services;

import com.nougat.authentication.dto.request.LoginRequest;
import com.nougat.authentication.dto.response.LoginResponse;
import com.nougat.domain.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthService(AuthenticationManager authenticationManager, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public LoginResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.username(),
                        request.password()
                )
        );
        // If we reach here, credentials are valid
        //implement cache control
        String token = jwtService.generateToken(request.username());
        return new LoginResponse(token);
    }
}
