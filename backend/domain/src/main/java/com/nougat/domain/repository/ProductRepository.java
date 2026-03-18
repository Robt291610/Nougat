package com.nougat.domain.repository;

import com.nougat.domain.entities.Product;

public interface ProductRepository {
    public void save(Product product);
    public Product findAll();
}
