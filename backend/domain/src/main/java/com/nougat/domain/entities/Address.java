package com.nougat.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "addresses")
@Getter
@Setter
@ToString(exclude = "user")
@Entity
public class Address {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID addressId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String street;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    private boolean isDefault;
}
