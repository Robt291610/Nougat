package com.nougat.application.usecases.products.commands;

import com.nougat.application.dto.products.ProductSummaryDto;
import com.nougat.application.mapper.GeneralMapper;
import com.nougat.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateProductCommand {
    private final ProductRepository repository;

    public CreateProductCommand(ProductRepository repository) {
        this.repository = repository;
    }

    public void handler(ProductSummaryDto product) {
        repository.save(GeneralMapper.dtoToProduct(product));
    }

}
