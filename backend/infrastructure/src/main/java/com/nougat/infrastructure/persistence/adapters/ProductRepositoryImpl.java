package com.nougat.infrastructure.persistence.adapters;

import com.nougat.domain.entities.Product;
import com.nougat.domain.repository.ProductRepository;
import com.nougat.infrastructure.persistence.repositories.JpaProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
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
    public List<Product> findAll(){
        return jpaRepository.findAll();
    }

    @Override
    public Product findById(UUID id){     //Fix
        Product product = new Product();
        return product;
    }
}
