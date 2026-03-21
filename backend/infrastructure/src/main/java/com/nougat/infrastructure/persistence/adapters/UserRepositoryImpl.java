package com.nougat.infrastructure.persistence.adapters;

import com.nougat.domain.entities.User;
import com.nougat.domain.repository.UserRepository;
import com.nougat.infrastructure.persistence.repositories.JpaUserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class UserRepositoryImpl implements UserRepository {

    JpaUserRepository jpaUserRepository;
    public UserRepositoryImpl(JpaUserRepository jpaUserRepository) { this.jpaUserRepository = jpaUserRepository; }


    @Override
    public List<User> findAll() {
        return jpaUserRepository.findAll();
    }

    @Override
    public User findById(UUID id) {
        return jpaUserRepository.findById(id).orElse(null);
    }

    @Override
    public void save(User user) {
        jpaUserRepository.save(user);
    }
}
