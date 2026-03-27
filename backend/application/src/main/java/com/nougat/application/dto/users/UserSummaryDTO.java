package com.nougat.application.dto.users;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
public class UserSummaryDTO {
    private String name;
    private String lastName;

    @NotBlank
    @Email

    private String email;
    private String passwordHash;
    private String phoneNumber;
}
