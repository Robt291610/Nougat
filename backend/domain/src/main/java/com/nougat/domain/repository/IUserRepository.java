package com.nougat.domain.repository;

import com.nougat.domain.entities.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IUserRepository {
    public List<User> findAll();
    public User findById(UUID id);
    public void save(User user);
    public Optional<User> findByEmail(String email);
    public Optional<User> findByUsername(String username);
    public List<User> findAllUsers();


}
