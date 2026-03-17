package com.nougat.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class ProductCategories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID productCategoryId;
}

//CREATE TABLE product_categories (
//        product_id BIGINT,
//        category_id BIGINT,
//
//        PRIMARY KEY(product_id, category_id),
//
//FOREIGN KEY (product_id) REFERENCES products(id),
//FOREIGN KEY (category_id) REFERENCES categories(id)
//        );
