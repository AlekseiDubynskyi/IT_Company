package com.solvd.it_company.dao.jdbc.mysql.Impl;

import com.solvd.it_company.connection.ConnectionUtil;
import com.solvd.it_company.dao.IEmployee_contactsDAO;
import com.solvd.it_company.models.Employee_contacts;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class Employee_contactsDAO implements IEmployee_contactsDAO {
    private static final Logger LOGGER = LogManager.getLogger(Employee_contactsDAO.class);
    List<Employee_contacts> employee_contacts = new LinkedList<>();

    @Override
    public Employee_contacts getEmployee_contactById(int id) {
        ResultSet resultSet = null;
        Statement statement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Employee_contacts WHERE id=" + id);
            if (resultSet.next()) {
                LOGGER.info(getEmployee_contactById(resultSet));
                return getEmployee_contactById(resultSet);
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

    private Employee_contacts getEmployee_contactById(ResultSet resultSet) throws SQLException {
        Employee_contacts newEmployee_contact = new Employee_contacts();
        newEmployee_contact.setId(resultSet.getInt("id"));
        newEmployee_contact.setPhone_number(resultSet.getString("phone_number"));
        newEmployee_contact.setEmail(resultSet.getString("email"));
        newEmployee_contact.setAddress_id(resultSet.getInt("address_id"));
        return newEmployee_contact;
    }

    @Override
    public List<Employee_contacts> getAllEmployee_contacts() {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM Employee_contacts");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employee_contacts.add(getEmployee_contactById(resultSet));
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
        return employee_contacts;
    }

    @Override
    public void addEmployee_contact(int id, String phone_number, String email, int address_id) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO Employee_contacts VALUE(default, ?, ?, ?)");
            preparedStatement.setString(1, phone_number);
            preparedStatement.setString(2, email);
            preparedStatement.setInt(3, address_id);
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
    public void updateEmployee_contact(Employee_contacts employee_contacts) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("UPDATE Employee_contacts SET phone_number=?, email=?, " +
                    "address_id=? WHERE id=?");
            preparedStatement.setString(1, employee_contacts.getPhone_number());
            preparedStatement.setString(2, employee_contacts.getEmail());
            preparedStatement.setInt(3, employee_contacts.getAddress_id());
            preparedStatement.setInt(4, employee_contacts.getId());
            if (preparedStatement.executeUpdate() == 1) {
                LOGGER.info("Update process is successful: " + employee_contacts.getId() + ", " + employee_contacts.getPhone_number());
            } else
                LOGGER.info("Update process was failed: " + employee_contacts.getId() + ", " + employee_contacts.getPhone_number());
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
    public void deleteEmployee_contact(int id) {
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
