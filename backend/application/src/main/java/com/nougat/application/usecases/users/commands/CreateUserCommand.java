package com.nougat.application.usecases.users.commands;

import com.nougat.application.dto.users.UserSummaryDTO;
import com.nougat.application.mapper.GeneralMapper;
import com.nougat.domain.entities.User;
import com.nougat.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateUserCommand {
    UserRepository userRepository;

    public CreateUserCommand(UserRepository userRepository) { this.userRepository = userRepository; }

    public void handler(UserSummaryDTO user) {
        User userRegister = GeneralMapper.dtoToUser(user);
        userRegister.setActive(true);
        userRepository.save(userRegister);
    }
}
