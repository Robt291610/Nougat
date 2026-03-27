package com.nougat.authentication.auth;

import com.nougat.application.dto.login.LogInDto;
import com.nougat.application.dto.users.UserSummaryDTO;
import com.nougat.authentication.dto.response.LoginResponse;
import com.nougat.authentication.dto.response.RegisterResponse;
import com.nougat.authentication.services.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/auth")
@Tag(name = "Auth", description = "Auth API")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LogInDto request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody UserSummaryDTO request) {
        return ResponseEntity.ok(authService.register(request));
    }

}
