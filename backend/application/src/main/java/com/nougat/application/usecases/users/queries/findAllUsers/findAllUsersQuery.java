package com.nougat.application.usecases.users.queries.findAllUsers;

import com.nougat.application.dto.users.UserSummaryDTO;
import com.nougat.application.mapper.GeneralMapper;
import com.nougat.domain.entities.User;
import com.nougat.domain.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class findAllUsersQuery {
    private final IUserRepository repository;

    public findAllUsersQuery(IUserRepository repository) {
        this.repository = repository;
    }

    public List<UserSummaryDTO> handle() {
        List<User> users = repository.findAll();
        return users.stream()
                .map(GeneralMapper::userToDto)
                        .toList();
    }
}
