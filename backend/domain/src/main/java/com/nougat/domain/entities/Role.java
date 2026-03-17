package com.nougat.domain.entities;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Role {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID roleId;

    private String roleName;
    private String roleDescription;

    @ManyToMany
    private Set<Permission> permissions;
}
