package com.nougat.infrastructure.persistence.adapters;

import com.nougat.domain.entities.User;
import com.nougat.domain.repository.IUserRepository;
import com.nougat.infrastructure.persistence.repositories.JpaUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepositoryImpl implements IUserRepository {

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
        Logger l = LoggerFactory.getLogger(UserRepositoryImpl.class);
        l.info("Saving user: " + user.toString());
        jpaUserRepository.save(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return jpaUserRepository.findByEmail(email);
    }

    @Override
    public Optional<User> findByUsername(String name) {
        return jpaUserRepository.findByName(name);
    }

    @Override
    public List<User> findAllUsers(){
        return jpaUserRepository.findAll();
    };
}
