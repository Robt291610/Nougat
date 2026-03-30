package com.nougat.application.dto.address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressSummaryDto {
    private String street;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    private boolean isDefault;
}
