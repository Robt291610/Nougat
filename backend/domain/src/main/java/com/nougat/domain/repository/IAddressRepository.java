package com.nougat.domain.repository;

import com.nougat.domain.entities.Address;
import com.nougat.domain.entities.Product;


public interface IAddressRepository {
    public void save(Address address);
}
