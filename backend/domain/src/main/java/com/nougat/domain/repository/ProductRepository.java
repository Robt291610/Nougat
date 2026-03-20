package com.nougat.domain.repository;

import com.nougat.domain.entities.Product;

import java.util.List;

public interface ProductRepository {
    public void save(Product product);
    public List<Product> findAll();
    public Product findById(String id);
}
