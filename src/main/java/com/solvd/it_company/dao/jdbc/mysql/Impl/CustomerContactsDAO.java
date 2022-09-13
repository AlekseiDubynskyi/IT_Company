package com.solvd.it_company.dao.jdbc.mysql.Impl;

import com.solvd.it_company.connection.ConnectionUtil;
import com.solvd.it_company.dao.ICustomerContactsDAO;
import com.solvd.it_company.models.CustomerContacts;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class CustomerContactsDAO implements ICustomerContactsDAO {
    private static final Logger LOGGER = LogManager.getLogger(CustomerContactsDAO.class);

    @Override
    public CustomerContacts getCustomerContactById(int id) {
        ResultSet resultSet = null;
        Statement statement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Customer_contacts WHERE id=" + id);
            if (resultSet.next()) {
                LOGGER.info(getCustomerContactById(resultSet));
                return getCustomerContactById(resultSet);
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

    private CustomerContacts getCustomerContactById(ResultSet resultSet) throws SQLException {
        CustomerContacts newCustomer_contact = new CustomerContacts();
        newCustomer_contact.setId(resultSet.getInt("id"));
        newCustomer_contact.setResponsiblePersonName(resultSet.getString("responsible_person_name"));
        newCustomer_contact.setPhoneNumber(resultSet.getString("phone_number"));
        newCustomer_contact.setEmail(resultSet.getString("email"));
        newCustomer_contact.setAddressId(resultSet.getInt("address_id"));
        return newCustomer_contact;
    }

    @Override
    public List<CustomerContacts> getAllCustomerContacts() {
        List<CustomerContacts> customer_contacts = new LinkedList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM Customer_contacts");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customer_contacts.add(getCustomerContactById(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(resultSet);
            ConnectionUtil.close(preparedStatement);
            ConnectionUtil.close(connection);
        }
        return customer_contacts;
    }

    @Override
    public void addCustomerContact(CustomerContacts customerContacts) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO Customer_contacts VALUE(default, ?, ?, ?, ?)");
            preparedStatement.setString(1, customerContacts.getResponsiblePersonName());
            preparedStatement.setString(2, customerContacts.getPhoneNumber());
            preparedStatement.setString(3, customerContacts.getEmail());
            preparedStatement.setInt(4, customerContacts.getAddressId());
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
    public void updateCustomerContact(CustomerContacts customerContacts) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("UPDATE Customer_contacts SET responsible_person_name=?, phone_number=?, " +
                    "email=?, address_id=? WHERE id=?");
            preparedStatement.setString(1, customerContacts.getResponsiblePersonName());
            preparedStatement.setString(2, customerContacts.getPhoneNumber());
            preparedStatement.setString(3, customerContacts.getEmail());
            preparedStatement.setInt(4, customerContacts.getAddressId());
            preparedStatement.setInt(5, customerContacts.getId());
            if (preparedStatement.executeUpdate() == 1) {
                LOGGER.info("Update process is successful: " + customerContacts.getId() + " - " + customerContacts.getResponsiblePersonName() + ", " + customerContacts.getPhoneNumber());
            } else
                LOGGER.info("Update process was failed: " + customerContacts.getId() + " - " + customerContacts.getResponsiblePersonName() + ", " + customerContacts.getPhoneNumber());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(preparedStatement);
            ConnectionUtil.close(connection);
        }
    }

    @Override
    public void deleteCustomerContact(int id) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM Customer_contacts WHERE id=" + id);
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
