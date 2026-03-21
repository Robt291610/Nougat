package com.nougat.infrastructure.persistence.repositories;

import com.nougat.domain.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface JpaRoleRepository extends JpaRepository<Role, UUID> {
}
