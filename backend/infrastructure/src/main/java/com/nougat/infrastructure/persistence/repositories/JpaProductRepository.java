package com.nougat.infrastructure.persistence.repositories;

import com.nougat.domain.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JpaProductRepository extends JpaRepository<Product, UUID> {
}
