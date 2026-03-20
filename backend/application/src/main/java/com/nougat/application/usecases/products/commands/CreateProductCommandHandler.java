package com.nougat.application.usecases.products.commands;

import com.nougat.application.dto.dashboard.ProductSummaryDto;
import com.nougat.application.mappers.GeneralMapper;
import com.nougat.domain.entities.Product;
import com.nougat.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CreateProductCommandHandler {
    private final ProductRepository repository;

    public CreateProductCommandHandler(ProductRepository repository) {
        this.repository = repository;
    }

    public UUID handler(ProductSummaryDto dto) {
        Product product = new Product();

        GeneralMapper.DtoToProduct(dto);

        repository.save(product);
        return product.getId();
    }

}
