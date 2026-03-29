package com.nougat.domain.repository;

import com.nougat.domain.entities.User;

import java.util.List;
import java.util.UUID;

public interface IGenericRepository {
    public User findById(UUID id);
    public List<User> findAll();
}
