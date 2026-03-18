package com.nougat.domain.entities;

import com.nougat.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
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
    private Products product;

    private Integer quantity;
    private LocalDateTime lastUpdated;
}
