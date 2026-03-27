package com.nougat.application.usecases.products.queries.GetById;

import com.nougat.application.dto.products.ProductSummaryDto;
import com.nougat.application.mapper.GeneralMapper;
import com.nougat.domain.entities.Product;
import com.nougat.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class GetProductByIdQueryHandler {

    private final ProductRepository repository;

    public GetProductByIdQueryHandler(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductSummaryDto handle(GetProductByIdQuery query) {
        Product product = repository.findById(query.getProductId());

        return GeneralMapper.productToDto(product);
    }
}
