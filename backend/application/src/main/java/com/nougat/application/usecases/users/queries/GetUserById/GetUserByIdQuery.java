package com.nougat.application.usecases.users.queries.GetUserById;

import com.nougat.application.dto.common.ById;
import com.nougat.application.dto.users.UserSummaryDTO;
import com.nougat.application.mapper.GeneralMapper;
import com.nougat.domain.entities.User;
import com.nougat.domain.repository.IUserRepository;
import org.springframework.stereotype.Service;

@Service
public class GetUserByIdQuery {
    private final IUserRepository repository;

    public GetUserByIdQuery(IUserRepository repository) {
        this.repository = repository;
    }

    public UserSummaryDTO handle(ById query) {
        User user = repository.findById(query.getId());

        return GeneralMapper.userToDto(user);
    }
}
