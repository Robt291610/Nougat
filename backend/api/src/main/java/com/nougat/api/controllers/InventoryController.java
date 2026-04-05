package com.nougat.api.controllers;

import com.nougat.application.dto.inventory.InventorySummaryDTO;
import com.nougat.application.usecases.inventory.queries.GetAllInventoryQuery;
import com.nougat.application.usecases.inventory.queries.GetInventoryByIdQuery;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/inventory")
public class InventoryController {

    private final GetAllInventoryQuery getAll;
    private final GetInventoryByIdQuery getById;

    public InventoryController(GetAllInventoryQuery getAll, GetInventoryByIdQuery getById) {
        this.getAll = getAll;
        this.getById = getById;
    }

    @GetMapping
    @Operation(summary = "get all inventory")
    public List<InventorySummaryDTO> getAll(){
        return getAll.handle();
    }

    @GetMapping("{id}")
    @Operation(summary = "Get inventory by id")
    public InventorySummaryDTO getById(@PathVariable UUID id){
        return getById.handle(id);
    }
}
