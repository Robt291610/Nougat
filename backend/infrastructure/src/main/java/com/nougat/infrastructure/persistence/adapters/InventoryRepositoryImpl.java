package com.nougat.infrastructure.persistence.adapters;

import com.nougat.domain.entities.Inventory;
import com.nougat.domain.repository.IInventoryRepository;
import com.nougat.infrastructure.persistence.repositories.JpaInventoryRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class InventoryRepositoryImpl implements IInventoryRepository {
    private final JpaInventoryRepository jpaInventoryRepository;

    public InventoryRepositoryImpl(JpaInventoryRepository jpaInventoryRepository) {
        this.jpaInventoryRepository = jpaInventoryRepository;
    }


    @Override
    public Inventory findById(UUID id) {
        return jpaInventoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Inventory> findAll() {
        return jpaInventoryRepository.findAll();
    }
}
