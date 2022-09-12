package com.solvd.it_company.dao.jdbc.mysql.Impl;

import com.solvd.it_company.connection.ConnectionUtil;
import com.solvd.it_company.dao.ICustomersDAO;
import com.solvd.it_company.models.Customer_types;
import com.solvd.it_company.models.Customers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class CustomersDAO implements ICustomersDAO {
    private static final Logger LOGGER = LogManager.getLogger(CustomersDAO.class);
    List<Customers> customers = new LinkedList<>();

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
            try {
                if (resultSet != null) resultSet.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (statement != null) statement.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (connection != null) connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
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
            try {
                if (preparedStatement != null) preparedStatement.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (connection != null) connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (resultSet != null) resultSet.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return customers;
    }

    @Override
    public void addCustomer(int id, String customer_name, int customer_type_id, int customer_contact_id) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO Customers VALUE(default, ?, ?, ?)");
            preparedStatement.setString(1, customer_name);
            preparedStatement.setInt(2, customer_type_id);
            preparedStatement.setInt(3, customer_contact_id);
            if (preparedStatement.executeUpdate() == 1) {
                LOGGER.info("Insertion is successful.");
            } else
                LOGGER.info("Insertion was failed.");
        } catch (SQLException e) {
            e.getMessage();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (connection != null) connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    @Override
    public void updateCustomer(Customers customers) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("UPDATE Customers SET customer_name=?, customer_type_id=?, customer_contact_id=? WHERE id=?");
            preparedStatement.setString(1, customers.getCustomer_name());
            preparedStatement.setInt(2, customers.getCustomer_type_id());
            preparedStatement.setInt(3, customers.getCustomer_contact_id());
            preparedStatement.setInt(4, customers.getId());
            if (preparedStatement.executeUpdate() == 1) {
                LOGGER.info("Update process is successful: " + customers.getId() + " - " + customers.getCustomer_name());
            } else
                LOGGER.info("Update process was failed: " + customers.getId() + " - " + customers.getCustomer_name());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (connection != null) connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
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
            try {
                if (preparedStatement != null) preparedStatement.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (connection != null) connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
