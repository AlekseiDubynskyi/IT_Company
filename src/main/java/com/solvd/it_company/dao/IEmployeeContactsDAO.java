package com.solvd.it_company.dao;

import com.solvd.it_company.models.EmployeeContacts;

import java.util.List;

public interface IEmployeeContactsDAO {
    EmployeeContacts getEmployeeContactById(int id);

    List<EmployeeContacts> getAllEmployeeContacts();

    void addEmployeeContact(EmployeeContacts employeeContacts);

    void updateEmployeeContact(EmployeeContacts employeeContacts);

    void deleteEmployeeContact(int id);
}
