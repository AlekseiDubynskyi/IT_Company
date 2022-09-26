package com.solvd.it_company.dao.jdbc.mysql.Impl;

import com.solvd.it_company.connection.ConnectionUtil;
import com.solvd.it_company.dao.IServiceCategoryDAO;
import com.solvd.it_company.models.ServiceCategory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ServiceCategoryDAO implements IServiceCategoryDAO {
    private static final Logger LOGGER = LogManager.getLogger(ServiceCategoryDAO.class);

    @Override
    public ServiceCategory getServiceCategoryById(int id) {
        ResultSet resultSet = null;
        Statement statement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Service_category WHERE id=" + id);
            if (resultSet.next()) {
                LOGGER.info(getServiceCategoryById(resultSet));
                return getServiceCategoryById(resultSet);
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

    private ServiceCategory getServiceCategoryById(ResultSet resultSet) throws SQLException {
        ServiceCategory newServiceCategory = new ServiceCategory();
        newServiceCategory.setId(resultSet.getInt("id"));
        newServiceCategory.setServiceId(resultSet.getInt("service_id"));
        newServiceCategory.setCategoryId(resultSet.getInt("category_id"));
        return newServiceCategory;
    }

    @Override
    public List<ServiceCategory> getAllServiceCategories() {
        List<ServiceCategory> serviceCategories = new LinkedList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM Service_category");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                serviceCategories.add(getServiceCategoryById(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(resultSet);
            ConnectionUtil.close(preparedStatement);
            ConnectionUtil.close(connection);
        }
        return serviceCategories;
    }

    @Override
    public void addServiceCategory(ServiceCategory serviceCategory) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO Service_category VALUES(default, ?, ?)");
            preparedStatement.setInt(1, serviceCategory.getServiceId());
            preparedStatement.setInt(2, serviceCategory.getCategoryId());
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
    public void updateServiceCategory(ServiceCategory serviceCategory) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("UPDATE Service_category SET service_id=?, category_id=? WHERE id=?");
            preparedStatement.setInt(1, serviceCategory.getServiceId());
            preparedStatement.setInt(2, serviceCategory.getCategoryId());
            preparedStatement.setInt(3, serviceCategory.getId());
            if (preparedStatement.executeUpdate() == 1) {
                LOGGER.info("Update process is successful: " + serviceCategory.getId() + " - " + serviceCategory.getServiceId() + serviceCategory.getCategoryId());
            } else
                LOGGER.info("Update process was failed: " + serviceCategory.getId() + " - " + serviceCategory.getServiceId() + serviceCategory.getCategoryId());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(preparedStatement);
            ConnectionUtil.close(connection);
        }
    }

    @Override
    public void deleteServiceCategory(int id) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM Service_category WHERE id=" + id);
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
