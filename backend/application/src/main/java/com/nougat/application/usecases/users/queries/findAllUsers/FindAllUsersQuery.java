package com.nougat.application.usecases.users.queries.findAllUsers;

import com.nougat.application.dto.users.UserSummaryDTO;
import com.nougat.application.mapper.GeneralMapper;
import com.nougat.domain.entities.User;
import com.nougat.domain.repository.IUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindAllUsersQuery {
    private final IUserRepository repository;

    public FindAllUsersQuery(IUserRepository repository) {
        this.repository = repository;
    }

    public List<UserSummaryDTO> handle() {
        List<User> users = repository.findAll();

        return users.stream()
                .map(GeneralMapper::userToDto)
                        .toList();
    }
}
