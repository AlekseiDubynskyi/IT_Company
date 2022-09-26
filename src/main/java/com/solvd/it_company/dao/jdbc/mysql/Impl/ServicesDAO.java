package com.solvd.it_company.dao.jdbc.mysql.Impl;

import com.solvd.it_company.connection.ConnectionUtil;
import com.solvd.it_company.dao.IServicesDAO;
import com.solvd.it_company.models.Services;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ServicesDAO implements IServicesDAO {
    private static final Logger LOGGER = LogManager.getLogger(ServicesDAO.class);

    @Override
    public Services getServiceById(int id) {
        ResultSet resultSet = null;
        Statement statement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Services WHERE id=" + id);
            if (resultSet.next()) {
                LOGGER.info(getServiceById(resultSet));
                return getServiceById(resultSet);
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

    private Services getServiceById(ResultSet resultSet) throws SQLException {
        Services newService = new Services();
        newService.setId(resultSet.getInt("id"));
        newService.setServiceName(resultSet.getString("service_name"));
        newService.setLeadTime(resultSet.getString("lead_time"));
        return newService;
    }

    @Override
    public List<Services> getAllServices() {
        List<Services> services = new LinkedList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM Services");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                services.add(getServiceById(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(resultSet);
            ConnectionUtil.close(preparedStatement);
            ConnectionUtil.close(connection);
        }
        return services;
    }

    @Override
    public void addService(Services services) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO Services VALUES(default, ?, ?)");
            preparedStatement.setString(1, services.getServiceName());
            preparedStatement.setString(2, services.getServiceName());
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
    public void updateService(Services services) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("UPDATE Services SET service_name=?, " +
                    "lead_time=? WHERE id=?");
            preparedStatement.setString(1, services.getServiceName());
            preparedStatement.setString(2, services.getLeadTime());
            preparedStatement.setInt(3, services.getId());
            if (preparedStatement.executeUpdate() == 1) {
                LOGGER.info("Update process is successful: " + services.getId() + " - " + services.getServiceName() + " " + services.getLeadTime());
            } else
                LOGGER.info("Update process was failed: " + services.getId() + " - " + services.getServiceName() + " " + services.getLeadTime());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(preparedStatement);
            ConnectionUtil.close(connection);
        }
    }

    @Override
    public void deleteService(int id) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM Services WHERE id=" + id);
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
