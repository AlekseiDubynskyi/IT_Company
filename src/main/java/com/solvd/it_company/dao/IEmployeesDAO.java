package com.solvd.it_company.dao;

import com.solvd.it_company.models.Employees;

import java.util.List;

public interface IEmployeesDAO {
    Employees getEmployeeById(int id);

    List<Employees> getAllEmployees();

    void addEmployee(Employees employees);

    void updateEmployee(Employees employees);

    void deleteEmployee(int id);
}

