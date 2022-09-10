package com.solvd.it_company.dao;

import com.solvd.it_company.models.Addresses;
import com.solvd.it_company.models.Customer_types;

import java.util.List;

public interface ICustomer_typesDAO {
    Customer_types getCustomer_typeById(int id);

    List<Customer_types> getAllCustomer_types();

    void addCustomer_type(int id, String customer_type);

    void updateCustomer_type(Customer_types customer_types);

    void deleteCustomer_type(int id);
}
