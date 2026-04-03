package com.nougat.application.usecases.inventory.queries;

import com.nougat.application.dto.inventory.InventorySummaryDTO;
import com.nougat.domain.repository.IInventoryRepository;
import org.springframework.stereotype.Service;

@Service
public class GetAllQuery {
    private final IInventoryRepository repository;

    public GetAllQuery(IInventoryRepository repository) {
        this.repository = repository;
    }

    public InventorySummaryDTO handle(){
        return repository.findAll();
    }
}
