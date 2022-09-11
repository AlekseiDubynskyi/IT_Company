package com.solvd.it_company.dao.jdbc.mysql.Impl;

import com.solvd.it_company.connection.ConnectionUtil;
import com.solvd.it_company.dao.ICustomer_typesDAO;
import com.solvd.it_company.models.Customer_types;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class Customer_typesDAO implements ICustomer_typesDAO {
    List<Customer_types> customer_types = new LinkedList<>();

    @Override
    public Customer_types getCustomer_typeById(int id) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Customer_types WHERE id=" + id);
            if (resultSet.next()) {
                System.out.println(getCustomer_typeById(resultSet));
                return getCustomer_typeById(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Customer_types getCustomer_typeById(ResultSet resultSet) throws SQLException {
        Customer_types newCustomer_type = new Customer_types();
        newCustomer_type.setId(resultSet.getInt("id"));
        newCustomer_type.setCustomer_type(resultSet.getString("customer_type"));
        return newCustomer_type;
    }

    @Override
    public List<Customer_types> getAllCustomer_types() {
        PreparedStatement preparedStatement;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM Customer_types");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customer_types.add(getCustomer_typeById(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer_types;
    }

    @Override
    public void addCustomer_type(int id, String customer_type) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Customer_types VALUE(default, ?)");
            preparedStatement.setString(1, customer_type);
            if (preparedStatement.executeUpdate() == 1) {
                System.out.println("Insertion is successful.");
            } else
                System.out.println("Insertion was failed.");
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    @Override
    public void updateCustomer_type(Customer_types customer_types) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Customer_types SET customer_type=? WHERE id=?");
            preparedStatement.setString(1, customer_types.getCustomer_type());
            preparedStatement.setInt(2, customer_types.getId());
            if (preparedStatement.executeUpdate() == 1) {
                System.out.println("Update process is successful: " + customer_types.getId() + " - " + customer_types.getCustomer_type());
            } else
                System.out.println("Update process was failed: " + customer_types.getId() + " - " + customer_types.getCustomer_type());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCustomer_type(int id) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Customer_types WHERE id=" + id);
            if (preparedStatement.executeUpdate() == 1) {
                System.out.println("Delete process is successful.");
            } else
                System.out.println("Delete process was failed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
