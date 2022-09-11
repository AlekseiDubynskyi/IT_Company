package com.solvd.it_company.dao.jdbc.mysql.Impl;

import com.solvd.it_company.connection.ConnectionUtil;
import com.solvd.it_company.dao.IEmployee_contactsDAO;
import com.solvd.it_company.models.Employee_contacts;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class Employee_contactsDAO implements IEmployee_contactsDAO {
    List<Employee_contacts> employee_contacts = new LinkedList<>();

    @Override
    public Employee_contacts getEmployee_contactById(int id) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Employee_contacts WHERE id=" + id);
            if (resultSet.next()) {
                System.out.println(getEmployee_contactById(resultSet));
                return getEmployee_contactById(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Employee_contacts getEmployee_contactById(ResultSet resultSet) throws SQLException {
        Employee_contacts newEmployee_contact = new Employee_contacts();
        newEmployee_contact.setId(resultSet.getInt("id"));
        newEmployee_contact.setPhone_number(resultSet.getString("phone_number"));
        newEmployee_contact.setEmail(resultSet.getString("email"));
        newEmployee_contact.setAddress_id(resultSet.getInt("address_id"));
        return newEmployee_contact;
    }

    @Override
    public List<Employee_contacts> getAllEmployee_contacts() {
        PreparedStatement preparedStatement;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM Employee_contacts");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employee_contacts.add(getEmployee_contactById(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee_contacts;
    }

    @Override
    public void addEmployee_contact(int id, String phone_number, String email, int address_id) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Employee_contacts VALUE(default, ?, ?, ?)");
            preparedStatement.setString(1, phone_number);
            preparedStatement.setString(2, email);
            preparedStatement.setInt(3, address_id);
            if (preparedStatement.executeUpdate() == 1) {
                System.out.println("Insertion is successful.");
            } else
                System.out.println("Insertion was failed.");
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    @Override
    public void updateEmployee_contact(Employee_contacts employee_contacts) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Employee_contacts SET phone_number=?, email=?, " +
                    "address_id=? WHERE id=?");
            preparedStatement.setString(1, employee_contacts.getPhone_number());
            preparedStatement.setString(2, employee_contacts.getEmail());
            preparedStatement.setInt(3, employee_contacts.getAddress_id());
            preparedStatement.setInt(4, employee_contacts.getId());
            if (preparedStatement.executeUpdate() == 1) {
                System.out.println("Update process is successful: " + employee_contacts.getId() + ", " + employee_contacts.getPhone_number());
            } else
                System.out.println("Update process was failed: " + employee_contacts.getId() + ", " + employee_contacts.getPhone_number());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteEmployee_contact(int id) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Employee_contacts WHERE id=" + id);
            if (preparedStatement.executeUpdate() == 1) {
                System.out.println("Delete process is successful.");
            } else
                System.out.println("Delete process was failed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
