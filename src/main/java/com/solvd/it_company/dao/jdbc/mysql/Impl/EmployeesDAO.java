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
    List<Employees> employees = new LinkedList<>();

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

    private Employees getEmployeeById(ResultSet resultSet) throws SQLException {
        Employees newEmployee = new Employees();
        newEmployee.setId(resultSet.getInt("id"));
        newEmployee.setFirst_name(resultSet.getString("first_name"));
        newEmployee.setLast_name(resultSet.getString("last_name"));
        newEmployee.setPosition_id(resultSet.getInt("position_id"));
        newEmployee.setContact_id(resultSet.getInt("contact_id"));
        newEmployee.setTeam_id(resultSet.getInt("team_id"));
        return newEmployee;
    }


    @Override
    public List<Employees> getAllEmployees() {
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
        return employees;
    }

    @Override
    public void addEmployee(int id, String first_name, String last_name, int position_id, int contact_id, int team_id) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO Employees VALUE(default, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, first_name);
            preparedStatement.setString(2, last_name);
            preparedStatement.setInt(3, position_id);
            preparedStatement.setInt(4, contact_id);
            preparedStatement.setInt(5, team_id);
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
    public void updateEmployee(Employees employees) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("UPDATE Employees SET first_name=?, " +
                    "last_name=?, position_id=?, contact_id=?, team_id=? WHERE id=?");
            preparedStatement.setString(1, employees.getFirst_name());
            preparedStatement.setString(2, employees.getLast_name());
            preparedStatement.setInt(3, employees.getPosition_id());
            preparedStatement.setInt(4, employees.getContact_id());
            preparedStatement.setInt(5, employees.getTeam_id());
            preparedStatement.setInt(6, employees.getId());
            if (preparedStatement.executeUpdate() == 1) {
                LOGGER.info("Update process is successful: " + employees.getId() + " - " + employees.getFirst_name() + " " + employees.getLast_name());
            } else
                LOGGER.info("Update process was failed: " + employees.getId() + " - " + employees.getFirst_name() + " " + employees.getLast_name());
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
