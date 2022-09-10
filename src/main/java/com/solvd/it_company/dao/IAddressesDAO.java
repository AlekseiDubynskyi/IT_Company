package com.solvd.it_company.dao;

import com.solvd.it_company.models.Addresses;
import com.solvd.it_company.models.City;

import java.util.List;
import java.util.Optional;

public interface IAddressesDAO {
    Addresses getAddressById(int id);
    List<Addresses> getAllAddresses();
    void insertAddress(int id, String address, String district, String postal_code, City city);
    void updateAddress(Addresses addresses);
    void deleteAddress(int id);
}
