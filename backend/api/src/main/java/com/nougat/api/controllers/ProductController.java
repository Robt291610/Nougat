package com.nougat.api.controllers;

import com.nougat.application.dto.products.ProductSummaryDto;
import com.nougat.application.dto.users.UserSummaryDTO;
import com.nougat.application.usecases.products.commands.CreateProductCommand;
import com.nougat.application.usecases.products.commands.UpdateProductCommand;
import com.nougat.application.usecases.products.queries.GetAll.GetAllProductsQuery;
import com.nougat.application.usecases.users.queries.GetUserById.GetUserByIdQuery;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/products")
@Tag(name = "Products", description = "Product API")
public class ProductController {

    private final GetAllProductsQuery getAll;
    private final CreateProductCommand create;
    private final UpdateProductCommand update;
    private final GetUserByIdQuery getUser;

    public ProductController(GetAllProductsQuery getAll, CreateProductCommand create, UpdateProductCommand update, GetUserByIdQuery getUser) {
        this.getAll = getAll;
        this.create = create;
        this.update = update;
        this.getUser = getUser;
    }

    @GetMapping("all")
    @Operation(summary = "Get all products")
    public List<ProductSummaryDto> getAllProducts() {
        return getAll.handler();
    }

    @PostMapping("register")
    @Operation(summary = "register a product")
    public void registerProduct(@RequestBody ProductSummaryDto product) {
        create.handler(product);
    }

    @PutMapping("update")
    @Operation(summary = "update a product")
    public void updateProduct(@RequestBody ProductSummaryDto product) {
        update.handler(product);
    }

    @GetMapping("{id}")
    @Operation(summary = "get a product by id")
    public UserSummaryDTO getProductById(@PathVariable UUID id) {
        return getUser.handle(id);
    }
}
