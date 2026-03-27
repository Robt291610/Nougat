package com.nougat.authentication.dto.response;

public record LoginResponse(String token, String type) {
    public LoginResponse(String token) {
        this(token, "Bearer");
    }
}
