package com.nougat.authentication.mapper;

import com.nougat.authentication.dto.user.UserD;
import com.nougat.domain.entities.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDetails userToDetails(User user) {
        UserD userD = new UserD();
        userD.setName(user.getName());
        userD.setPassword(userD.getPassword());
        return userD;
    }
}
