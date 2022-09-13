package com.solvd.it_company.dao;

import com.solvd.it_company.models.CustomerContacts;

import java.util.List;

public interface ICustomerContactsDAO {
    CustomerContacts getCustomerContactById(int id);

    List<CustomerContacts> getAllCustomerContacts();

    void addCustomerContact(CustomerContacts customerContacts);

    void updateCustomerContact(CustomerContacts customerContacts);

    void deleteCustomerContact(int id);
}
