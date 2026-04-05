package com.nougat.api.controllers;

import com.nougat.application.dto.inventory.InventorySummaryDTO;
import com.nougat.application.usecases.inventory.queries.GetAllInventoryQuery;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/inventory")
public class InventoryController {

    private final GetAllInventoryQuery getAll;

    public InventoryController(GetAllInventoryQuery getAll) {
        this.getAll = getAll;
    }

    @GetMapping
    @Operation(summary = "get all inventory")
    public List<InventorySummaryDTO> getAll(){
        return getAll.handle();
    }


}
