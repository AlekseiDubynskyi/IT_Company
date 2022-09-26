package com.solvd.it_company.dao.jdbc.mysql.Impl;

import com.solvd.it_company.connection.ConnectionUtil;
import com.solvd.it_company.dao.IEmployeeContactsDAO;
import com.solvd.it_company.models.EmployeeContacts;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class EmployeeContactsDAO implements IEmployeeContactsDAO {
    private static final Logger LOGGER = LogManager.getLogger(EmployeeContactsDAO.class);

    @Override
    public EmployeeContacts getEmployeeContactById(int id) {
        ResultSet resultSet = null;
        Statement statement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Employee_contacts WHERE id=" + id);
            if (resultSet.next()) {
                LOGGER.info(getEmployeeContactById(resultSet));
                return getEmployeeContactById(resultSet);
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

    private EmployeeContacts getEmployeeContactById(ResultSet resultSet) throws SQLException {
        EmployeeContacts newEmployee_contact = new EmployeeContacts();
        newEmployee_contact.setId(resultSet.getInt("id"));
        newEmployee_contact.setPhoneNumber(resultSet.getString("phone_number"));
        newEmployee_contact.setEmail(resultSet.getString("email"));
        newEmployee_contact.setAddressId(resultSet.getInt("address_id"));
        return newEmployee_contact;
    }

    @Override
    public List<EmployeeContacts> getAllEmployeeContacts() {
        List<EmployeeContacts> employee_contacts = new LinkedList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM Employee_contacts");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employee_contacts.add(getEmployeeContactById(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(resultSet);
            ConnectionUtil.close(preparedStatement);
            ConnectionUtil.close(connection);
        }
        return employee_contacts;
    }

    @Override
    public void addEmployeeContact(EmployeeContacts employeeContacts) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO Employee_contacts VALUES(default, ?, ?, ?)");
            preparedStatement.setString(1, employeeContacts.getPhoneNumber());
            preparedStatement.setString(2, employeeContacts.getEmail());
            preparedStatement.setInt(3, employeeContacts.getAddressId());
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
    public void updateEmployeeContact(EmployeeContacts employeeContacts) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("UPDATE Employee_contacts SET phone_number=?, email=?, " +
                    "address_id=? WHERE id=?");
            preparedStatement.setString(1, employeeContacts.getPhoneNumber());
            preparedStatement.setString(2, employeeContacts.getEmail());
            preparedStatement.setInt(3, employeeContacts.getAddressId());
            preparedStatement.setInt(4, employeeContacts.getId());
            if (preparedStatement.executeUpdate() == 1) {
                LOGGER.info("Update process is successful: " + employeeContacts.getId() + ", " + employeeContacts.getPhoneNumber());
            } else
                LOGGER.info("Update process was failed: " + employeeContacts.getId() + ", " + employeeContacts.getPhoneNumber());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(preparedStatement);
            ConnectionUtil.close(connection);
        }
    }

    @Override
    public void deleteEmployeeContact(int id) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM Employee_contacts WHERE id=" + id);
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
