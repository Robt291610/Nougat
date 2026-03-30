package com.nougat.infrastructure.persistence.adapters;

import com.nougat.domain.entities.Address;
import com.nougat.domain.repository.IAddressRepository;
import com.nougat.infrastructure.persistence.repositories.JpaAddressRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class AddressRepositoryImpl implements IAddressRepository {

    private final JpaAddressRepository jpaAddressRepository;

    public AddressRepositoryImpl(JpaAddressRepository jpaAddressRepository) {
        this.jpaAddressRepository = jpaAddressRepository;
    }

    public void save(Address address) {
        jpaAddressRepository.save(address);
    }
}
