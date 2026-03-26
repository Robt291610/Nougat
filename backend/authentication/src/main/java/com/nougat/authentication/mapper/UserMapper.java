package com.nougat.authentication.mapper;

import com.nougat.authentication.dto.user.UserD;
import com.nougat.domain.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    public User detailsToUser(UserD details) {
        User user = new User();
        user.setName(details.getName());
        user.setLastName(details.getLastName());
        user.setName(details.getUsername());
        user.setPasswordHash(details.getPassword());
        user.setPhoneNumber(details.getPhoneNumber());
        return user;
    }
}
