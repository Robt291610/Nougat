package com.nougat.application.usecases.products.queries.GetById;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class GetProductByIdQuery {
    private UUID productId;
}
