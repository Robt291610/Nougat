package com.nougat.application.usecases.products.queries.GetById;

import com.nougat.application.dto.common.ById;
import com.nougat.application.dto.products.ProductSummaryDto;
import com.nougat.application.mapper.GeneralMapper;
import com.nougat.domain.entities.Product;
import com.nougat.domain.repository.IProductRepository;
import org.springframework.stereotype.Service;

@Service
public class GetProductByIdQuery {

    private final IProductRepository repository;

    public GetProductByIdQuery(IProductRepository repository) {
        this.repository = repository;
    }

    public ProductSummaryDto handle(ById query) {
        Product product = repository.findById(query.getId());

        return GeneralMapper.productToDto(product);
    }
}
