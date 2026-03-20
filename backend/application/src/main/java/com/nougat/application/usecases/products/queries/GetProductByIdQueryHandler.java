package com.nougat.application.usecases.products.queries;

import com.nougat.application.dto.dashboard.ProductSummaryDto;
import com.nougat.application.mappers.GeneralMapper;
import com.nougat.domain.entities.Product;
import com.nougat.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class GetProductByIdQueryHandler {

    private final ProductRepository repository;
    private final GeneralMapper mapper;

    public GetProductByIdQueryHandler(ProductRepository repository, GeneralMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ProductSummaryDto handle(GetProductByIdQuery query) {
        Product product = repository.findById(query.getProductId());

        return mapper.ProductToDto(product);
    }
}
