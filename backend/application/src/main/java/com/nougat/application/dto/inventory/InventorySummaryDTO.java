package com.nougat.application.dto.inventory;

import com.nougat.domain.entities.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class InventorySummaryDTO {
    private UUID id;
    private Product productId;
    private Integer quantity;
}
