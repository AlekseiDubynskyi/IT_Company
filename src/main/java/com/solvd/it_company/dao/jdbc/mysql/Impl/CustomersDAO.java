package com.solvd.it_company.dao.jdbc.mysql.Impl;

import com.solvd.it_company.connection.ConnectionUtil;
import com.solvd.it_company.dao.ICustomersDAO;
import com.solvd.it_company.models.Customers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class CustomersDAO implements ICustomersDAO {
    private static final Logger LOGGER = LogManager.getLogger(CustomersDAO.class);

    @Override
    public Customers getCustomerById(int id) {
        ResultSet resultSet = null;
        Statement statement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Customers WHERE id=" + id);
            if (resultSet.next()) {
                LOGGER.info(getCustomerById(resultSet));
                return getCustomerById(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(resultSet);
            ConnectionUtil.close(statement);
            ConnectionUtil.close(connection);
        }
        return null;
    }

    private Customers getCustomerById(ResultSet resultSet) throws SQLException {
        Customers newCustomer = new Customers();
        newCustomer.setId(resultSet.getInt("id"));
        newCustomer.setCustomerName(resultSet.getString("customer_name"));
        newCustomer.setCustomerTypeId(resultSet.getInt("customer_type_id"));
        newCustomer.setCustomerContactId(resultSet.getInt("customer_contact_id"));
        return newCustomer;
    }

    @Override
    public List<Customers> getAllCustomers() {
        List<Customers> customers = new LinkedList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM Customers");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customers.add(getCustomerById(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(resultSet);
            ConnectionUtil.close(preparedStatement);
            ConnectionUtil.close(connection);
        }
        return customers;
    }

    @Override
    public void addCustomer(Customers customers) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO Customers VALUE(default, ?, ?, ?)");
            preparedStatement.setString(1, customers.getCustomerName());
            preparedStatement.setInt(2, customers.getCustomerTypeId());
            preparedStatement.setInt(3, customers.getCustomerContactId());
            if (preparedStatement.executeUpdate() == 1) {
                LOGGER.info("Insertion is successful.");
            } else
                LOGGER.info("Insertion was failed.");
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        } finally {
            ConnectionUtil.close(preparedStatement);
            ConnectionUtil.close(connection);
        }
    }

    @Override
    public void updateCustomer(Customers customers) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("UPDATE Customers SET customer_name=?, customer_type_id=?, customer_contact_id=? WHERE id=?");
            preparedStatement.setString(1, customers.getCustomerName());
            preparedStatement.setInt(2, customers.getCustomerTypeId());
            preparedStatement.setInt(3, customers.getCustomerContactId());
            preparedStatement.setInt(4, customers.getId());
            if (preparedStatement.executeUpdate() == 1) {
                LOGGER.info("Update process is successful: " + customers.getId() + " - " + customers.getCustomerName());
            } else
                LOGGER.info("Update process was failed: " + customers.getId() + " - " + customers.getCustomerName());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(preparedStatement);
            ConnectionUtil.close(connection);
        }
    }

    @Override
    public void deleteCustomer(int id) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM Customers WHERE id=" + id);
            if (preparedStatement.executeUpdate() == 1) {
                LOGGER.info("Delete process is successful.");
            } else
                LOGGER.info("Delete process was failed.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(preparedStatement);
            ConnectionUtil.close(connection);
        }
    }
}
