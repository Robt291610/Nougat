package com.nougat.authentication.services;

import com.nougat.authentication.mapper.UserMapper;
import com.nougat.domain.entities.User;
import com.nougat.domain.repository.UserRepository;
import com.nougat.infrastructure.persistence.adapters.UserRepositoryImpl;
import com.nougat.infrastructure.persistence.repositories.JpaUserRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final JpaUserRepository userRepository;
    private final UserMapper userMapper;

    public CustomUserDetailsService(JpaUserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return userMapper.userToDetails(userRepository.findByName(name)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + name)));
    }
}
