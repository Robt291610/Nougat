package com.nougat.api.config;

import com.nougat.domain.entities.Role;
import com.nougat.domain.repository.RoleRepository;
import com.nougat.domain.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SampleDataConfig {
    RoleRepository roleRepository;

    SampleDataConfig(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Bean
    public CommandLineRunner initRoles(RoleRepository roleRepository) {
        return args -> {

            if (roleRepository.count() == 0) {
                roleRepository.save(new Role("ADMIN", "this user has access to everything"));
                roleRepository.save(new Role("USER", "can buy stuffs or just tour over the store"));
            }
        };
    }
}
