package com.solvd.it_company.dao.jdbc.mysql.Impl;

import com.solvd.it_company.connection.ConnectionUtil;
import com.solvd.it_company.dao.IEmployeesDAO;
import com.solvd.it_company.models.Employees;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class EmployeesDAO implements IEmployeesDAO {
    private static final Logger LOGGER = LogManager.getLogger(EmployeesDAO.class);

    @Override
    public Employees getEmployeeById(int id) {
        ResultSet resultSet = null;
        Statement statement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Employees WHERE id=" + id);
            if (resultSet.next()) {
                LOGGER.info(getEmployeeById(resultSet));
                return getEmployeeById(resultSet);
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

    private Employees getEmployeeById(ResultSet resultSet) throws SQLException {
        Employees newEmployee = new Employees();
        newEmployee.setId(resultSet.getInt("id"));
        newEmployee.setFirstName(resultSet.getString("first_name"));
        newEmployee.setLastName(resultSet.getString("last_name"));
        newEmployee.setPositionId(resultSet.getInt("position_id"));
        newEmployee.setContactId(resultSet.getInt("contact_id"));
        newEmployee.setTeamId(resultSet.getInt("team_id"));
        return newEmployee;
    }


    @Override
    public List<Employees> getAllEmployees() {
        List<Employees> employees = new LinkedList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM Employees");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employees.add(getEmployeeById(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(resultSet);
            ConnectionUtil.close(preparedStatement);
            ConnectionUtil.close(connection);
        }
        return employees;
    }

    @Override
    public void addEmployee(Employees employees) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO Employees VALUES(default, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, employees.getFirstName());
            preparedStatement.setString(2, employees.getLastName());
            preparedStatement.setInt(3, employees.getPositionId());
            preparedStatement.setInt(4, employees.getContactId());
            preparedStatement.setInt(5, employees.getTeamId());
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
    public void updateEmployee(Employees employees) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("UPDATE Employees SET first_name=?, " +
                    "last_name=?, position_id=?, contact_id=?, team_id=? WHERE id=?");
            preparedStatement.setString(1, employees.getFirstName());
            preparedStatement.setString(2, employees.getLastName());
            preparedStatement.setInt(3, employees.getPositionId());
            preparedStatement.setInt(4, employees.getContactId());
            preparedStatement.setInt(5, employees.getTeamId());
            preparedStatement.setInt(6, employees.getId());
            if (preparedStatement.executeUpdate() == 1) {
                LOGGER.info("Update process is successful: " + employees.getId() + " - " + employees.getFirstName() + " " + employees.getLastName());
            } else
                LOGGER.info("Update process was failed: " + employees.getId() + " - " + employees.getFirstName() + " " + employees.getLastName());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(preparedStatement);
            ConnectionUtil.close(connection);
        }
    }

    @Override
    public void deleteEmployee(int id) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM Employees WHERE id=" + id);
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
