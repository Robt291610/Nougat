package com.nougat.application.usecases.users.queries;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class GetUserByIdQuery {
    private UUID productId;
}
