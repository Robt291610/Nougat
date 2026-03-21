package com.nougat.application.mapper;

import com.nougat.application.dto.products.ProductSummaryDto;
import com.nougat.application.dto.users.UserSummaryDTO;
import com.nougat.domain.entities.Product;
import com.nougat.domain.entities.User;
import org.springframework.stereotype.Component;

//a + 7
@Component
public class GeneralMapper {
    // region ========== Products ==========
    public static Product dtoToProduct(ProductSummaryDto dto){
        Product product = new Product();
        product.setProductName(dto.getProductName());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        return product;
    }

    public static ProductSummaryDto productToDto(Product product){
        ProductSummaryDto dto = new ProductSummaryDto();
        dto.setProductId(product.getId());
        dto.setProductName(product.getProductName());
        dto.setDescription(product.getDescription());
        dto.setPrice(product.getPrice());
        return dto;
    }
    //endregion

    // region ========== Clients ==========

    //endregion

    // region ========== Users ==========
    public static User dtoToUser (UserSummaryDTO dto){
        User user = new User();
        user.setName(dto.getName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setPasswordHash(dto.getPasswordHash());
        user.setPhoneNumber(dto.getPhoneNumber());
        return  user;
    };

    //endregion
}
