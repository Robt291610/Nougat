package com.nougat.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Permission {
    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID permissionId;

    private String permissionName;
    private String permissionDescription;
}
