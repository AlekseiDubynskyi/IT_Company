package com.solvd.it_company.dao.jdbc.mysql.Impl;

import com.solvd.it_company.connection.ConnectionUtil;
import com.solvd.it_company.dao.ICustomerTypesDAO;
import com.solvd.it_company.models.CustomerTypes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class CustomerTypesDAO implements ICustomerTypesDAO {
    private static final Logger LOGGER = LogManager.getLogger(CustomerTypesDAO.class);

    @Override
    public CustomerTypes getCustomerTypeById(int id) {
        ResultSet resultSet = null;
        Statement statement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Customer_types WHERE id=" + id);
            if (resultSet.next()) {
                LOGGER.info(getCustomerTypeById(resultSet));
                return getCustomerTypeById(resultSet);
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

    private CustomerTypes getCustomerTypeById(ResultSet resultSet) throws SQLException {
        CustomerTypes newCustomerType = new CustomerTypes();
        newCustomerType.setId(resultSet.getInt("id"));
        newCustomerType.setCustomerType(resultSet.getString("customer_type"));
        return newCustomerType;
    }

    @Override
    public List<CustomerTypes> getAllCustomerTypes() {
        List<CustomerTypes> customerTypes = new LinkedList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM Customer_types");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customerTypes.add(getCustomerTypeById(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(resultSet);
            ConnectionUtil.close(preparedStatement);
            ConnectionUtil.close(connection);
        }
        return customerTypes;
    }

    @Override
    public void addCustomerType(CustomerTypes customerTypes) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO Customer_types VALUE(default, ?)");
            preparedStatement.setString(1, customerTypes.getCustomerType());
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
    public void updateCustomerType(CustomerTypes customerTypes) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("UPDATE Customer_types SET customer_type=? WHERE id=?");
            preparedStatement.setString(1, customerTypes.getCustomerType());
            preparedStatement.setInt(2, customerTypes.getId());
            if (preparedStatement.executeUpdate() == 1) {
                LOGGER.info("Update process is successful: " + customerTypes.getId() + " - " + customerTypes.getCustomerType());
            } else
                LOGGER.info("Update process was failed: " + customerTypes.getId() + " - " + customerTypes.getCustomerType());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(preparedStatement);
            ConnectionUtil.close(connection);
        }
    }

    @Override
    public void deleteCustomerType(int id) {
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
            ConnectionUtil.close(preparedStatement);
            ConnectionUtil.close(connection);
        }
    }
}
