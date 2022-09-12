package com.solvd.it_company.dao.jdbc.mysql.Impl;

import com.solvd.it_company.connection.ConnectionUtil;
import com.solvd.it_company.dao.ICustomer_typesDAO;
import com.solvd.it_company.models.Customer_types;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class Customer_typesDAO implements ICustomer_typesDAO {
    private static final Logger LOGGER = LogManager.getLogger(Customer_typesDAO.class);
    List<Customer_types> customer_types = new LinkedList<>();

    @Override
    public Customer_types getCustomer_typeById(int id) {
        ResultSet resultSet = null;
        Statement statement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Customer_types WHERE id=" + id);
            if (resultSet.next()) {
                LOGGER.info(getCustomer_typeById(resultSet));
                return getCustomer_typeById(resultSet);
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

    private Customer_types getCustomer_typeById(ResultSet resultSet) throws SQLException {
        Customer_types newCustomer_type = new Customer_types();
        newCustomer_type.setId(resultSet.getInt("id"));
        newCustomer_type.setCustomer_type(resultSet.getString("customer_type"));
        return newCustomer_type;
    }

    @Override
    public List<Customer_types> getAllCustomer_types() {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM Customer_types");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customer_types.add(getCustomer_typeById(resultSet));
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
        return customer_types;
    }

    @Override
    public void addCustomer_type(int id, String customer_type) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO Customer_types VALUE(default, ?)");
            preparedStatement.setString(1, customer_type);
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
    public void updateCustomer_type(Customer_types customer_types) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("UPDATE Customer_types SET customer_type=? WHERE id=?");
            preparedStatement.setString(1, customer_types.getCustomer_type());
            preparedStatement.setInt(2, customer_types.getId());
            if (preparedStatement.executeUpdate() == 1) {
                LOGGER.info("Update process is successful: " + customer_types.getId() + " - " + customer_types.getCustomer_type());
            } else
                LOGGER.info("Update process was failed: " + customer_types.getId() + " - " + customer_types.getCustomer_type());
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
    public void deleteCustomer_type(int id) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM Customer_types WHERE id=" + id);
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
