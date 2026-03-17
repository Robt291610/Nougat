package com.nougat.domain.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Products productId;

    private Integer quantity;
    private LocalDateTime lastUpdated;

}
/*
* CREATE TABLE inventory (
    product_id BIGINT PRIMARY KEY,
    quantity INT NOT NULL,
    last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (product_id) REFERENCES products(id)
);*/
