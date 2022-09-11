package com.solvd.it_company.dao;

import com.solvd.it_company.models.Employee_contacts;
import com.solvd.it_company.models.Employees;
import com.solvd.it_company.models.Positions;
import com.solvd.it_company.models.Teams;

import java.util.List;

public interface IEmployeesDAO {
    Employees getEmployeeById(int id);

    List<Employees> getAllEmployees();

    void addEmployee(int id, String first_name, String last_name, int position_id, int contact_id, int team_id);

    void updateEmployee(Employees employees);

    void deleteEmployee(int id);
}

