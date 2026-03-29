package com.nougat.application.usecases.users.queries.GetUserByEmail;

import com.nougat.application.mapper.GeneralMapper;
import com.nougat.domain.entities.User;
import com.nougat.domain.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetUserByEmailQuery {
    private final IUserRepository repository;

    public GetUserByEmailQuery(IUserRepository repository) {
        this.repository = repository;
    }

    public String handle(String query) {
        Optional<User> user = repository.findByEmail(query);
        return GeneralMapper.userToEmail(user);
    }
}
