package com.nougat.application.usecases.inventory.queries;

import com.nougat.application.dto.inventory.InventorySummaryDTO;
import com.nougat.application.mapper.GeneralMapper;
import com.nougat.domain.repository.IInventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllInventoryQuery {
    private final IInventoryRepository repository;

    public GetAllInventoryQuery(IInventoryRepository repository) {
        this.repository = repository;
    }

    public List<InventorySummaryDTO> handle(){
        return GeneralMapper.inventoryToDto(repository.findAll());
    }
}
