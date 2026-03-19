package com.nougat.application.mappers;

import com.nougat.application.dto.dashboard.ProductSummaryDto;
import com.nougat.domain.entities.Product;

public class GeneralMapper {
    //Products
    public static Product DtoToProduct(ProductSummaryDto dto){
        Product product = new Product();
        product.setId(dto.getProductId());
        product.setProductName(dto.getProductName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        return product;
    }

    //Clients

}
