package com.solvd.it_company.dao.jdbc.mysql.Impl;

import com.solvd.it_company.connection.ConnectionUtil;
import com.solvd.it_company.dao.ICustomer_contactsDAO;
import com.solvd.it_company.models.Customer_contacts;
import com.solvd.it_company.models.Employee_contacts;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class Customer_contactsDAO implements ICustomer_contactsDAO {
    private static final Logger LOGGER = LogManager.getLogger(Customer_contactsDAO.class);
    List<Customer_contacts> customer_contacts = new LinkedList<>();

    @Override
    public Customer_contacts getCustomer_contactById(int id) {
        ResultSet resultSet = null;
        Statement statement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Customer_contacts WHERE id=" + id);
            if (resultSet.next()) {
                LOGGER.info(getCustomer_contactById(resultSet));
                return getCustomer_contactById(resultSet);
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
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM Customer_contacts");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customer_contacts.add(getCustomer_contactById(resultSet));
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
        return customer_contacts;
    }

    @Override
    public void addCustomer_contact(int id, String responsible_person_name, String phone_number, String email, int address_id) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO Customer_contacts VALUE(default, ?, ?, ?, ?)");
            preparedStatement.setString(1, responsible_person_name);
            preparedStatement.setString(2, phone_number);
            preparedStatement.setString(3, email);
            preparedStatement.setInt(4, address_id);
            if (preparedStatement.executeUpdate() == 1) {
                LOGGER.info("Insertion is successful.");
            } else
                LOGGER.info("Insertion was failed.");
        } catch (SQLException e) {
            e.getMessage();
        }  finally {
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
    public void updateCustomer_contact(Customer_contacts customer_contacts) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("UPDATE Customer_contacts SET responsible_person_name=?, phone_number=?, " +
                    "email=?, address_id=? WHERE id=?");
            preparedStatement.setString(1, customer_contacts.getResponsible_person_name());
            preparedStatement.setString(2, customer_contacts.getPhone_number());
            preparedStatement.setString(3, customer_contacts.getEmail());
            preparedStatement.setInt(4, customer_contacts.getAddress_id());
            preparedStatement.setInt(5, customer_contacts.getId());
            if (preparedStatement.executeUpdate() == 1) {
                LOGGER.info("Update process is successful: " + customer_contacts.getId() + " - " + customer_contacts.getResponsible_person_name() + ", " + customer_contacts.getPhone_number());
            } else
                LOGGER.info("Update process was failed: " + customer_contacts.getId() + " - " + customer_contacts.getResponsible_person_name() + ", " + customer_contacts.getPhone_number());
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
    public void deleteCustomer_contacts(int id) {
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
