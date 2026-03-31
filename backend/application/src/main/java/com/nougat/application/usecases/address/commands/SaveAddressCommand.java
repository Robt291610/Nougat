package com.nougat.application.usecases.address.commands;

import com.nougat.application.dto.address.AddressSummaryDto;
import com.nougat.application.dto.products.ProductSummaryDto;
import com.nougat.application.mapper.GeneralMapper;
import com.nougat.application.usecases.users.queries.GetUserById.GetUserByIdQuery;
import com.nougat.domain.entities.Address;
import com.nougat.domain.entities.User;
import com.nougat.domain.repository.IAddressRepository;
import com.nougat.domain.repository.IProductRepository;
import com.nougat.domain.repository.IUserRepository;
import org.springframework.stereotype.Service;

@Service
public class SaveAddressCommand {
    private final IAddressRepository repository;
    private final IUserRepository userRepository;

    public SaveAddressCommand(IAddressRepository repository, IUserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    public void handler(AddressSummaryDto address) {
        User foundUser = userRepository.findById(address.getUser());

        repository.save(GeneralMapper.dtoToAddress(address, foundUser));
    }
}
