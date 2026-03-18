package com.nougat.infrastructure.persistence.adapters;

import com.nougat.domain.entities.Product;
import com.nougat.domain.repository.ProductRepository;
import com.nougat.infrastructure.persistence.repositories.JpaProductRepository;

public class ProductRepositoryImpl  implements ProductRepository {

    public ProductRepositoryImpl(JpaProductRepository productRepository) {
        this.jpaRepository = productRepository;
    }

    private final JpaProductRepository jpaRepository;

    @Override
    public void save(Product product){
        jpaRepository.save(product);
    }

    @Override
    public Product findAll(){
        return jpaRepository.findAll().stream().findFirst().orElse(null);
    }
}
