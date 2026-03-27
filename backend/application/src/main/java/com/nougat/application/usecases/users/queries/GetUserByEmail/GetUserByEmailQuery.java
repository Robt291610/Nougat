package com.nougat.application.usecases.users.queries.GetUserByEmail;

import com.nougat.application.dto.users.ByEmail;
import com.nougat.application.mapper.GeneralMapper;
import com.nougat.domain.entities.User;
import com.nougat.domain.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetUserByEmailQuery {
    private final UserRepository repository;

    public GetUserByEmailQuery(UserRepository repository) {
        this.repository = repository;
    }

    public String handle(String query) {
        Optional<User> user = repository.findByEmail(query);
        return GeneralMapper.userToEmail(user);
    }
}
