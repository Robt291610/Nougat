package com.nougat.application.usecases.products.queries.GetAll;

import com.nougat.application.dto.dashboard.ProductSummaryDto;
import com.nougat.application.mappers.GeneralMapper;
import com.nougat.application.usecases.products.queries.GetById.GetProductByIdQuery;
import com.nougat.domain.entities.Product;
import com.nougat.domain.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class GetAllProductsQueryHandler {
    private final ProductRepository repository;
    private Logger log = LoggerFactory.getLogger(GetAllProductsQueryHandler.class);

    public GetAllProductsQueryHandler(ProductRepository repository) {
        this.repository = repository;
    }

    public List<ProductSummaryDto> handle() {
        List<Product> products = repository.findAll();

        return products.stream()
                .map(GeneralMapper::productToDto)
                .toList();
    }
}
