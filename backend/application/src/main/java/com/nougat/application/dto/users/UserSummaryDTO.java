package com.nougat.application.dto.users;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserSummaryDTO {
    private UUID id;
    private String name;
    private String lastName;
    private String email;
    private String passwordHash;
    private String phoneNumber;
}
