package com.nougat.infrastructure.testUserRepoIMPL;

import com.nougat.domain.entities.User;
import com.nougat.infrastructure.persistence.adapters.UserRepositoryImpl;
import com.nougat.infrastructure.persistence.repositories.JpaUserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TestIMPL {
    @Mock
    private JpaUserRepository jpaUserRepository;

    @InjectMocks
    private UserRepositoryImpl userRepositoryImpl;

    @Test
    void save_shouldCallJpaRepository() {
        // Arrange
        User user = new User();
        user.setName("Robert");
        user.setLastName("Cedeno");
        user.setEmail("robert@gmail.com");
        user.setPasswordHash("hashedPassword");
        user.setPhoneNumber("598745669");

        // Act
        userRepositoryImpl.save(user);

        verify(jpaUserRepository, times(1)).save(user);
    }
}
