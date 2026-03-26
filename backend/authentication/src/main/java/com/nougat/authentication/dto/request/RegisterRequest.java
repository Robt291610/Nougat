package com.nougat.authentication.dto.request;

public record RegisterRequest(String name, String lastName, String email, String password, String phoneNumber) {}
