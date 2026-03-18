package com.nougat.domain.entities;

import com.nougat.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString(exclude = "products")
@Entity
public class ProductImage extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "product_id")
    private Product product;

    private String imageUrl;
}
