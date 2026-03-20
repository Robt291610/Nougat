package com.nougat.application.mappers;

import com.nougat.application.dto.dashboard.ProductSummaryDto;
import com.nougat.domain.entities.Product;
import org.springframework.stereotype.Component;

@Component
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

    public static ProductSummaryDto ProductToDto(Product product){
        ProductSummaryDto dto = new ProductSummaryDto();
        dto.setProductId(product.getId());
        dto.setProductName(product.getProductName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        return dto;
    }

    //Clients

}
