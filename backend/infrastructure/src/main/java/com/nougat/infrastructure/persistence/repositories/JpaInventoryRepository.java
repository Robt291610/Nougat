package com.nougat.infrastructure.persistence.repositories;

import com.nougat.domain.entities.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaInventoryRepository extends JpaRepository<Inventory, UUID> {
}
