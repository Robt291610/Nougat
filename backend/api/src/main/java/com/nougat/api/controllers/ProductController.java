package com.nougat.api.controllers;

import com.nougat.application.dto.products.ProductSummaryDto;
import com.nougat.application.usecases.products.commands.CreateProductCommandHandler;
import com.nougat.application.usecases.products.queries.GetAll.GetAllProductsQueryHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
@Tag(name = "Products", description = "Product APIs")
public class ProductController {

    private final GetAllProductsQueryHandler getAllHandler;
    private final CreateProductCommandHandler createHandler;

    public ProductController(GetAllProductsQueryHandler getAllHandler, CreateProductCommandHandler createHandler) {
        this.getAllHandler = getAllHandler;
        this.createHandler = createHandler;
    }

    @GetMapping("all")
    @Operation(summary = "Get all products")
    public List<ProductSummaryDto> getAllProducts() {
        return getAllHandler.handle();
    }

    @PostMapping("register")
    @Operation(summary = "register a product")
    public void registerProduct(@RequestBody ProductSummaryDto product) {
        createHandler.handler(product);
    }
}
