package com.nougat.domain.entities;

import com.nougat.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "inventory")
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "product")
public class Inventory extends BaseEntity {

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "product_id")
    private Product product;

    private Integer quantity;

    @CreationTimestamp
    private LocalDateTime lastUpdated;
}
