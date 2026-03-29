package com.nougat.domain.repository;

import com.nougat.domain.entities.Role;

public interface IRoleRepository {
    public void save(Role role);
    public Integer count();
    public Integer getCount();

}
