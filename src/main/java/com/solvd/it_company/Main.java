package com.solvd.it_company;

import com.solvd.it_company.connection.ConnectionUtil;
import com.solvd.it_company.dao.ICountryDAO;
import com.solvd.it_company.dao.jdbc.mysql.Impl.CountryDAO;
import com.solvd.it_company.models.Country;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    private static ICountryDAO CountryDAO;
    public static void main(String[] args) {
        // create a new connection from MySQLJDBCUtil
        try (Connection conn = ConnectionUtil.getConnection()) {
            // print out a message
            System.out.println(String.format("Connected to database %s"
                    + "successfully.", conn.getCatalog()));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        CountryDAO = new CountryDAO();
        List<Country> countries = CountryDAO.getAllCountries();
        System.out.println(countries);
        
        CountryDAO.addCountry(7, "Austria");

    }
}
