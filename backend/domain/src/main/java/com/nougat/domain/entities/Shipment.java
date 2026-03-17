package com.nougat.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Shipment {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID shipmentId;

    private String trackingNumber;
    private String carrier;
    private LocalDateTime shippedDate;
}
