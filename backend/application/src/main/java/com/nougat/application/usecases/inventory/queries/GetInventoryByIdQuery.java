package com.nougat.application.usecases.inventory.queries;

import com.nougat.application.dto.inventory.InventorySummaryDTO;
import com.nougat.application.mapper.GeneralMapper;
import com.nougat.domain.repository.IInventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GetInventoryByIdQuery {
    private final IInventoryRepository repository;

    public GetInventoryByIdQuery(IInventoryRepository repository) {
        this.repository = repository;
    }

    public InventorySummaryDTO handle(UUID id){
        return GeneralMapper.inventoryToDto(repository.findById(id));
    }
}
