package com.solvd.it_company.dao.jdbc.mysql.Impl;

import com.solvd.it_company.connection.ConnectionUtil;
import com.solvd.it_company.dao.ICityDAO;
import com.solvd.it_company.models.City;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class CityDAO implements ICityDAO {
    List<City> cities = new LinkedList<>();

    @Override
    public City getCityById(int id) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM City WHERE id=" + id);
            if (resultSet.next()) {
                System.out.println(getCityById(resultSet));
                return getCityById(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
        PreparedStatement preparedStatement;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM City");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                cities.add(getCityById(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }

    @Override
    public void addCity(int id, String city, int country_id) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO City VALUE(default, ?, ?)");
            preparedStatement.setString(1, city);
            preparedStatement.setInt(2, country_id);
            if (preparedStatement.executeUpdate() == 1) {
                System.out.println("Insertion is successful.");
            } else
                System.out.println("Insertion was failed.");
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    @Override
    public void updateCity(City city) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE City SET city=?, country_id=? WHERE id=?");
            preparedStatement.setString(1, city.getCity());
            preparedStatement.setInt(2, city.getCountry_id());
            preparedStatement.setInt(3, city.getId());
            if (preparedStatement.executeUpdate() == 1) {
                System.out.println("Update process is successful: " + city.getId() + "-" + city.getCity());
            } else
                System.out.println("Update process was failed: " + city.getId() + "-" + city.getCity());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCity(int id) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM City WHERE id=" + id);
            if (preparedStatement.executeUpdate() == 1) {
                System.out.println("Delete process is successful.");
            } else
                System.out.println("Delete process was failed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
