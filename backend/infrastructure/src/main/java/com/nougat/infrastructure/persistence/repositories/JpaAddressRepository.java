package com.nougat.infrastructure.persistence.repositories;

import com.nougat.domain.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaAddressRepository extends JpaRepository<Address, UUID> {
}
