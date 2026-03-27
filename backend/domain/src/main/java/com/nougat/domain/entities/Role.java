package com.nougat.domain.entities;


import com.nougat.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Role extends BaseEntity {

    public Role(String roleName, String roleDescription) {
        this.roleName = roleName;
        this.roleDescription = roleDescription;
    }

    private String roleName;
    private String roleDescription;

    @ManyToMany
    private Set<Permission> permissions;
}
