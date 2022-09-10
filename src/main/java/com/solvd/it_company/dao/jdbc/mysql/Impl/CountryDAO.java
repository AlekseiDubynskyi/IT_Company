package com.solvd.it_company.dao.jdbc.mysql.Impl;

import com.solvd.it_company.connection.ConnectionUtil;
import com.solvd.it_company.dao.ICountryDAO;
import com.solvd.it_company.models.Country;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class CountryDAO implements ICountryDAO {
    List<Country> countries = new LinkedList<>();

    @Override
    public Country getCountryById(int id) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Country WHERE id=" + id);
            if (resultSet.next()) {
                System.out.println(getCountryById(resultSet));
                return getCountryById(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Country getCountryById(ResultSet resultSet) throws SQLException {
        Country newCountry = new Country();
        newCountry.setId(resultSet.getInt("id"));
        newCountry.setCountry(resultSet.getString("country"));
        return newCountry;
    }

    @Override
    public List<Country> getAllCountries() {
        PreparedStatement preparedStatement;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM Country");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                countries.add(getCountryById(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countries;
    }

    @Override
    public void addCountry(int id, String country) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Country VALUE(default, ?)");
            preparedStatement.setString(1, country);
            if (preparedStatement.executeUpdate() == 1) {
                System.out.println("Insertion is successful.");
            } else
                System.out.println("Insertion was failed.");
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    @Override
    public void updateCountry(Country country) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Country SET country=? WHERE id=?");
            preparedStatement.setString(1, country.getCountry());
            preparedStatement.setInt(2, country.getId());
            if (preparedStatement.executeUpdate() == 1) {
                System.out.println("Update process is successful: " + country.getId() + "-" + country.getCountry());
            } else
                System.out.println("Update process was failed: " + country.getId() + "-" + country.getCountry());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCountry(int id) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Country WHERE id=" + id);
            if (preparedStatement.executeUpdate() == 1) {
                System.out.println("Delete process is successful.");
            } else
                System.out.println("Delete process was failed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
