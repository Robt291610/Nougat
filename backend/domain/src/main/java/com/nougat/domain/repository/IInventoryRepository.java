package com.nougat.domain.repository;

import com.nougat.domain.entities.Inventory;

import java.util.List;
import java.util.UUID;

public interface IInventoryRepository {
    public Inventory findById(UUID id);
    public List<Inventory> findAll(UUID id);
}
