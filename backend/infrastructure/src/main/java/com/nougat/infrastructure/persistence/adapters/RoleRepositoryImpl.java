package com.nougat.infrastructure.persistence.adapters;

import com.nougat.domain.entities.Role;
import com.nougat.domain.repository.IRoleRepository;
import com.nougat.infrastructure.persistence.repositories.JpaRoleRepository;
import org.springframework.stereotype.Repository;

@Repository
public class RoleRepositoryImpl implements IRoleRepository {

    public RoleRepositoryImpl(JpaRoleRepository jpaRoleRepository) { this.jpaRoleRepository = jpaRoleRepository; }

    JpaRoleRepository jpaRoleRepository;


    @Override
    public void save(Role role) {
        jpaRoleRepository.save(role);
    }

    @Override
    public Integer count() {
        Integer count = 0;

        if (getCount() != 0)
            count = getCount();

        return count;
    }

    @Override
    public Integer getCount() {
        return jpaRoleRepository.findAll().size();
    }
}
