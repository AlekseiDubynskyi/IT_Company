package com.solvd.it_company.dao;

import com.solvd.it_company.models.Addresses;
import com.solvd.it_company.models.Employee_contacts;

import java.util.List;

public interface IEmployee_contactsDAO {
    Employee_contacts getEmployee_contactById(int id);

    List<Employee_contacts> getAllEmployee_contacts();

    void addEmployee_contact(int id, String phone_number, String email, int address_id);

    void updateEmployee_contact(Employee_contacts employee_contacts);

    void deleteEmployee_contact(int id);
}
