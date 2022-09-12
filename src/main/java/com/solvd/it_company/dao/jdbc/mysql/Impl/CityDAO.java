package com.solvd.it_company.dao.jdbc.mysql.Impl;

import com.solvd.it_company.connection.ConnectionUtil;
import com.solvd.it_company.dao.ICityDAO;
import com.solvd.it_company.models.City;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class CityDAO implements ICityDAO {
    private static final Logger LOGGER = LogManager.getLogger(CityDAO.class);
    List<City> cities = new LinkedList<>();

    @Override
    public City getCityById(int id) {
        ResultSet resultSet = null;
        Statement statement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM City WHERE id=" + id);
            if (resultSet.next()) {
                LOGGER.info(getCityById(resultSet));
                return getCityById(resultSet);
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

    private City getCityById(ResultSet resultSet) throws SQLException {
        City newCity = new City();
        newCity.setId(resultSet.getInt("id"));
        newCity.setCity(resultSet.getString("city"));
        newCity.setCountry_id(resultSet.getInt("country_id"));
        return newCity;
    }

    @Override
    public List<City> getAllCities() {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM City");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                cities.add(getCityById(resultSet));
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
        return cities;
    }

    @Override
    public void addCity(int id, String city, int country_id) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO City VALUE(default, ?, ?)");
            preparedStatement.setString(1, city);
            preparedStatement.setInt(2, country_id);
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
    public void updateCity(City city) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("UPDATE City SET city=?, country_id=? WHERE id=?");
            preparedStatement.setString(1, city.getCity());
            preparedStatement.setInt(2, city.getCountry_id());
            preparedStatement.setInt(3, city.getId());
            if (preparedStatement.executeUpdate() == 1) {
                LOGGER.info("Update process is successful: " + city.getId() + " - " + city.getCity());
            } else
                LOGGER.info("Update process was failed: " + city.getId() + " - " + city.getCity());
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
    public void deleteCity(int id) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM City WHERE id=" + id);
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
