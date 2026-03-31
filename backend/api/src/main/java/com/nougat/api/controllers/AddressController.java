package com.nougat.api.controllers;

import com.nougat.application.dto.address.AddressSummaryDto;
import com.nougat.application.usecases.address.commands.SaveAddressCommand;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/address")
@Tag(name = "address", description = "Address API")
public class AddressController {

    private final SaveAddressCommand saveAddressCommand;

    public AddressController(SaveAddressCommand saveAddressCommand) {
        this.saveAddressCommand = saveAddressCommand;
    }

    @PostMapping("save")
    @Operation(summary = "save user address")
    public void save(AddressSummaryDto address) {
        saveAddressCommand.handler(address);
    }
}
