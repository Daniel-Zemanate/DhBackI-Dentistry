package com.example.apicl58trabajofinaldh.service;

import com.example.apicl58trabajofinaldh.model.dto.AddressDTO;
import com.example.apicl58trabajofinaldh.model.entity.Address;

import java.util.List;

public interface AddressServiceInterface {

    AddressDTO createAddress(Address address);
    AddressDTO readAddressById(Long id);
    List<AddressDTO> readAllAddress();
    AddressDTO updateAddress(Address address);
    AddressDTO deleteAddressById(Long id);

}
