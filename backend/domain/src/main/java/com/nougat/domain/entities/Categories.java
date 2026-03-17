package com.nougat.domain.entities;


import jakarta.persistence.*;
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
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID categoryId;

    private String categoryName;

    @ManyToOne
    @JoinColumn(name = "parent_category_id", nullable = false)
    private Categories ParentCategoryId;

}