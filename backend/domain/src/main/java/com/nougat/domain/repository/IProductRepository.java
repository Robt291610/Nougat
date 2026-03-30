package com.nougat.domain.repository;

import com.nougat.domain.entities.Product;

import java.util.List;
import java.util.UUID;

public interface IProductRepository {
    public void save(Product product);
    public List<Product> findAll();
    public Product findById(UUID id);
}
