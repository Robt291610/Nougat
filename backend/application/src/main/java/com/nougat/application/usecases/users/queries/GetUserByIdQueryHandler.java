package com.nougat.application.usecases.users.queries;

import com.nougat.application.dto.products.ProductSummaryDto;
import com.nougat.application.dto.users.UserSummaryDTO;
import com.nougat.application.mapper.GeneralMapper;
import com.nougat.application.usecases.products.queries.GetById.GetProductByIdQuery;
import com.nougat.domain.entities.Product;
import com.nougat.domain.entities.User;
import com.nougat.domain.repository.ProductRepository;
import com.nougat.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class GetUserByIdQueryHandler {
    private final UserRepository repository;

    public GetUserByIdQueryHandler(UserRepository repository) {
        this.repository = repository;
    }

    public UserSummaryDTO handle(GetUserByIdQuery query) {
        User user = repository.findById(query.getProductId());

        return GeneralMapper.userToDto(user);
    }
}
