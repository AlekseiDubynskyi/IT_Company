package com.solvd.it_company.dao.jdbc.mysql.Impl;

import com.solvd.it_company.connection.ConnectionUtil;
import com.solvd.it_company.dao.ICustomersDAO;
import com.solvd.it_company.models.Customer_types;
import com.solvd.it_company.models.Customers;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class CustomersDAO implements ICustomersDAO {
    List<Customers> customers = new LinkedList<>();

    @Override
    public Customers getCustomerById(int id) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Customers WHERE id=" + id);
            if (resultSet.next()) {
                System.out.println(getCustomerById(resultSet));
                return getCustomerById(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Customers getCustomerById(ResultSet resultSet) throws SQLException {
        Customers newCustomer = new Customers();
        newCustomer.setId(resultSet.getInt("id"));
        newCustomer.setCustomer_name(resultSet.getString("customer_name"));
        newCustomer.setCustomer_type_id(resultSet.getInt("customer_type_id"));
        newCustomer.setCustomer_contact_id(resultSet.getInt("customer_contact_id"));
        return newCustomer;
    }

    @Override
    public List<Customers> getAllCustomers() {
        PreparedStatement preparedStatement;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM Customers");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customers.add(getCustomerById(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public void addCustomer(int id, String customer_name, int customer_type_id, int customer_contact_id) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Customers VALUE(default, ?, ?, ?)");
            preparedStatement.setString(1, customer_name);
            preparedStatement.setInt(2, customer_type_id);
            preparedStatement.setInt(3, customer_contact_id);
            if (preparedStatement.executeUpdate() == 1) {
                System.out.println("Insertion is successful.");
            } else
                System.out.println("Insertion was failed.");
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    @Override
    public void updateCustomer(Customers customers) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Customers SET customer_name=?, customer_type_id=?, customer_contact_id=? WHERE id=?");
            preparedStatement.setString(1, customers.getCustomer_name());
            preparedStatement.setInt(2, customers.getCustomer_type_id());
            preparedStatement.setInt(3, customers.getCustomer_contact_id());
            preparedStatement.setInt(4, customers.getId());
            if (preparedStatement.executeUpdate() == 1) {
                System.out.println("Update process is successful: " + customers.getId() + " - " + customers.getCustomer_name());
            } else
                System.out.println("Update process was failed: " + customers.getId() + " - " + customers.getCustomer_name());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCustomer(int id) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Customers WHERE id=" + id);
            if (preparedStatement.executeUpdate() == 1) {
                System.out.println("Delete process is successful.");
            } else
                System.out.println("Delete process was failed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
