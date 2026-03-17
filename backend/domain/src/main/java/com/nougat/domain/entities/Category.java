package com.nougat.domain.entities;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString(exclude = {"parentCategory", "subCategories"})
@Entity
public class Category {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID categoryId;

    private String categoryName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_category_id", nullable = true)
    private Category parentCategoryId;

}