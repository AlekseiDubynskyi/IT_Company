package com.solvd.it_company.dao;

import com.solvd.it_company.models.*;

import java.util.List;

public interface ICustomersDAO {
    Customers getCustomerById(int id);

    List<Customers> getAllCustomers();

    void addCustomer(Customers customers);

    void updateCustomer(Customers customers);

    void deleteCustomer(int id);
}
