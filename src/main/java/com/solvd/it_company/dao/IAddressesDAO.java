package com.solvd.it_company.dao;

import com.solvd.it_company.models.Addresses;
import com.solvd.it_company.models.City;

import java.util.List;

public interface IAddressesDAO {
    Addresses getAddressById(int id);

    List<Addresses> getAllAddresses();

    void addAddress(Addresses addresses);

    void updateAddress(Addresses addresses);

    void deleteAddress(int id);
}
