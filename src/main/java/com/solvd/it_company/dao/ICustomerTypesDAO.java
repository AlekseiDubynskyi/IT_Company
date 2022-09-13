package com.solvd.it_company.dao;

import com.solvd.it_company.models.CustomerTypes;

import java.util.List;

public interface ICustomerTypesDAO {
    CustomerTypes getCustomerTypeById(int id);

    List<CustomerTypes> getAllCustomerTypes();

    void addCustomerType(CustomerTypes customerTypes);

    void updateCustomerType(CustomerTypes customerTypes);

    void deleteCustomerType(int id);
}
