package com.nougat.application.usecases.products.queries.GetAll;

import com.nougat.application.dto.products.ProductSummaryDto;
import com.nougat.application.mapper.GeneralMapper;
import com.nougat.domain.entities.Product;
import com.nougat.domain.repository.IProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GetAllProductsQuery {
    private final IProductRepository repository;

    public GetAllProductsQuery(IProductRepository repository) {
        this.repository = repository;
    }

    public List<ProductSummaryDto> handler() {
        List<Product> products = repository.findAll();

        return products.stream()
                .map(GeneralMapper::productToDto)
                .toList();
    }
}
