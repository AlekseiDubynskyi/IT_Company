package com.solvd.it_company.dao;

import com.solvd.it_company.models.*;

import java.util.List;

public interface ICustomersDAO {
    Customers getCustomerById(int id);

    List<Customers> getAllCustomers();

    void addCustomer(int id, String customer_name, Customer_types customer_types, Customer_contacts customer_contacts);

    void updateCustomer(Customers customers);

    void deleteCustomer(int id);
}
