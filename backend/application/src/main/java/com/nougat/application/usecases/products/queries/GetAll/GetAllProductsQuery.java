package com.nougat.application.usecases.products.queries.GetAll;

import com.nougat.domain.entities.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetAllProductsQuery {
    private List<Product> products;
}
