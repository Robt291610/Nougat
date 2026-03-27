package com.nougat.application.usecases.users.queries.GetUserByEmail;

import com.nougat.application.dto.users.UserSummaryDTO;
import com.nougat.application.mapper.GeneralMapper;
import com.nougat.application.usecases.users.queries.GetUserById.GetUserByIdQuery;
import com.nougat.domain.entities.User;
import com.nougat.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetUserByEmailQueryHandler {
    private final UserRepository repository;

    public GetUserByEmailQueryHandler(UserRepository repository) {
        this.repository = repository;
    }

//    public UserSummaryDTO handle(GetUserByEmailQuery query) {
//        Optional<User> user = repository.findByEmail(query.getEmail());
//
//        return GeneralMapper.userToDto(user);
//    }
}
