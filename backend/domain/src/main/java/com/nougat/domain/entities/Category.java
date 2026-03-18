package com.nougat.domain.entities;
import com.nougat.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Table(name = "category")
@ToString(exclude = {"parentCategory", "subCategories"})
@Entity
public class Category extends BaseEntity {

    private String categoryName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_category_id", nullable = true)
    private Category parentCategoryId;

}