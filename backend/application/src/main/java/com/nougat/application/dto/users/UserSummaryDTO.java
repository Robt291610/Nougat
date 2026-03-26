package com.nougat.application.dto.users;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
public class UserSummaryDTO {
    private String name;
    private String lastName;
    private String email;
    private String passwordHash;
    private String phoneNumber;
}
