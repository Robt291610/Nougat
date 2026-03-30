package com.nougat.application.usecases.address.commands;

import com.nougat.application.dto.address.AddressSummaryDto;
import com.nougat.application.dto.products.ProductSummaryDto;
import com.nougat.application.mapper.GeneralMapper;
import com.nougat.domain.entities.Address;
import com.nougat.domain.repository.IAddressRepository;
import com.nougat.domain.repository.IProductRepository;
import org.springframework.stereotype.Service;

@Service
public class SaveAddressCommand {
    private final IAddressRepository repository;

    public SaveAddressCommand(IAddressRepository repository) {
        this.repository = repository;
    }

    public void handler(AddressSummaryDto address) {
        repository.save(GeneralMapper.dtoToAddress(address));
    }
}
