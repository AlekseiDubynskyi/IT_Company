package com.solvd.it_company.dao.jdbc.mysql.Impl;

import com.solvd.it_company.connection.ConnectionUtil;
import com.solvd.it_company.dao.IService_categoryDAO;
import com.solvd.it_company.dao.IServicesDAO;
import com.solvd.it_company.models.Categories;
import com.solvd.it_company.models.City;
import com.solvd.it_company.models.Service_category;
import com.solvd.it_company.models.Services;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class Service_categoryDAO implements IService_categoryDAO {
    private static final Logger LOGGER = LogManager.getLogger(Service_categoryDAO.class);
    List<Service_category> service_categories = new LinkedList<>();

    @Override
    public Service_category getService_categoryById(int id) {
        ResultSet resultSet = null;
        Statement statement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Service_category WHERE id=" + id);
            if (resultSet.next()) {
                LOGGER.info(getService_categoryById(resultSet));
                return getService_categoryById(resultSet);
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

    private Service_category getService_categoryById(ResultSet resultSet) throws SQLException {
        Service_category newService_category = new Service_category();
        newService_category.setId(resultSet.getInt("id"));
        newService_category.setId(resultSet.getInt("service_id"));
        newService_category.setId(resultSet.getInt("category_id"));
        return newService_category;
    }

    @Override
    public List<Service_category> getAllService_categories() {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM Service_category");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                service_categories.add(getService_categoryById(resultSet));
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
        return service_categories;
    }

    @Override
    public void addService_category(int id, int service_id, int category_id) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO Service_category VALUE(default, ?, ?)");
            preparedStatement.setInt(1, service_id);
            preparedStatement.setInt(2, category_id);
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
    public void updateService_category(Service_category service_category) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("UPDATE Service_category SET service_id=?, category_id=? WHERE id=?");
            preparedStatement.setInt(1, service_category.getService_id());
            preparedStatement.setInt(2, service_category.getCategory_id());
            preparedStatement.setInt(3, service_category.getId());
            if (preparedStatement.executeUpdate() == 1) {
                LOGGER.info("Update process is successful: " + service_category.getId() + " - " + service_category.getService_id() + service_category.getCategory_id());
            } else
                LOGGER.info("Update process was failed: " + service_category.getId() + " - " + service_category.getService_id() + service_category.getCategory_id());
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
    public void deleteService_category(int id) {
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
