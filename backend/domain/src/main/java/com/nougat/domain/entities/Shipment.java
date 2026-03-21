package com.nougat.domain.entities;

import com.nougat.domain.common.BaseEntity;
import jakarta.persistence.Entity;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
public class Shipment extends BaseEntity {

    private String trackingNumber;
    private String carrier;

    @CreationTimestamp
    private LocalDateTime shippedDate;
}
