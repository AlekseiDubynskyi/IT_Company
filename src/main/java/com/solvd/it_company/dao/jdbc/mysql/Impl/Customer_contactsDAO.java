package com.solvd.it_company.dao.jdbc.mysql.Impl;

import com.solvd.it_company.connection.ConnectionUtil;
import com.solvd.it_company.dao.ICustomer_contactsDAO;
import com.solvd.it_company.models.Customer_contacts;
import com.solvd.it_company.models.Employee_contacts;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class Customer_contactsDAO implements ICustomer_contactsDAO {
    List<Customer_contacts> customer_contacts = new LinkedList<>();

    @Override
    public Customer_contacts getCustomer_contactById(int id) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Customer_contacts WHERE id=" + id);
            if (resultSet.next()) {
                System.out.println(getCustomer_contactById(resultSet));
                return getCustomer_contactById(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Customer_contacts getCustomer_contactById(ResultSet resultSet) throws SQLException {
        Customer_contacts newCustomer_contact = new Customer_contacts();
        newCustomer_contact.setId(resultSet.getInt("id"));
        newCustomer_contact.setResponsible_person_name(resultSet.getString("responsible_person_name"));
        newCustomer_contact.setPhone_number(resultSet.getString("phone_number"));
        newCustomer_contact.setEmail(resultSet.getString("email"));
        newCustomer_contact.setAddress_id(resultSet.getInt("address_id"));
        return newCustomer_contact;
    }

    @Override
    public List<Customer_contacts> getAllCustomer_contacts() {
        PreparedStatement preparedStatement;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM Customer_contacts");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customer_contacts.add(getCustomer_contactById(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer_contacts;
    }

    @Override
    public void addCustomer_contact(int id, String responsible_person_name, String phone_number, String email, int address_id) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Customer_contacts VALUE(default, ?, ?, ?, ?)");
            preparedStatement.setString(1, responsible_person_name);
            preparedStatement.setString(2, phone_number);
            preparedStatement.setString(3, email);
            preparedStatement.setInt(4, address_id);
            if (preparedStatement.executeUpdate() == 1) {
                System.out.println("Insertion is successful.");
            } else
                System.out.println("Insertion was failed.");
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    @Override
    public void updateCustomer_contact(Customer_contacts customer_contacts) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Customer_contacts SET responsible_person_name=?, phone_number=?, " +
                    "email=?, address_id=? WHERE id=?");
            preparedStatement.setString(1, customer_contacts.getResponsible_person_name());
            preparedStatement.setString(2, customer_contacts.getPhone_number());
            preparedStatement.setString(3, customer_contacts.getEmail());
            preparedStatement.setInt(4, customer_contacts.getAddress_id());
            preparedStatement.setInt(5, customer_contacts.getId());
            if (preparedStatement.executeUpdate() == 1) {
                System.out.println("Update process is successful: " + customer_contacts.getId() + " - " + customer_contacts.getResponsible_person_name() + ", " + customer_contacts.getPhone_number());
            } else
                System.out.println("Update process was failed: " + customer_contacts.getId() + " - " + customer_contacts.getResponsible_person_name() + ", " + customer_contacts.getPhone_number());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCustomer_contacts(int id) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Customer_contacts WHERE id=" + id);
            if (preparedStatement.executeUpdate() == 1) {
                System.out.println("Delete process is successful.");
            } else
                System.out.println("Delete process was failed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
