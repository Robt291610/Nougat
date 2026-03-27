package com.nougat.api.controllers;

import com.nougat.application.dto.products.ProductSummaryDto;
import com.nougat.application.usecases.products.commands.CreateProductCommand;
import com.nougat.application.usecases.products.queries.GetAll.GetAllProductsQuery;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
@Tag(name = "Products", description = "Product API")
public class ProductController {

    private final GetAllProductsQuery getAll;
    private final CreateProductCommand create;

    public ProductController(GetAllProductsQuery getAll, CreateProductCommand create) {
        this.getAll = getAll;
        this.create = create;
    }

    @GetMapping("all")
    @Operation(summary = "Get all products")
    public List<ProductSummaryDto> getAllProducts() {
        return getAll.handle();
    }

    @PostMapping("register")
    @Operation(summary = "register a product")
    public void registerProduct(@RequestBody ProductSummaryDto product) {
        create.handler(product);
    }
}
