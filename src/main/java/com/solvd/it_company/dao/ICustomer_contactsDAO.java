package com.solvd.it_company.dao;

import com.solvd.it_company.models.Addresses;
import com.solvd.it_company.models.Customer_contacts;

import java.util.List;

public interface ICustomer_contactsDAO {
    Customer_contacts getCustomer_contactById(int id);

    List<Customer_contacts> getAllCustomer_contacts();

    void addCustomer_contact(int id, String responsible_person_name, String phone_number, String email, int address_id);

    void updateCustomer_contact(Customer_contacts customer_contacts);

    void deleteCustomer_contacts(int id);
}
