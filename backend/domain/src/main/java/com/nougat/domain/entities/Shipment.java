package com.nougat.domain.entities;

import com.nougat.domain.common.BaseEntity;
import jakarta.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class Shipment extends BaseEntity {

    private String trackingNumber;
    private String carrier;
    private LocalDateTime shippedDate;
}
