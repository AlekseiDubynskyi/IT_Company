package com.solvd.it_company;

import com.solvd.it_company.connection.ConnectionUtil;
import com.solvd.it_company.dao.ICountryDAO;
import com.solvd.it_company.dao.jdbc.mysql.Impl.CountryDAO;
import com.solvd.it_company.models.Country;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    private final static Logger MAIN_LOGGER = LogManager.getLogger(Main.class);
    private static ICountryDAO CountryDAO;
    public static void main(String[] args) throws InterruptedException {
        // create a new connection from MySQLJDBCUtil
        try (Connection connection = ConnectionUtil.getConnection()) {
            // print out a message
            System.out.println(String.format("Connected to database %s"
                    + " successfully.", connection.getCatalog()));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }


        CountryDAO = new CountryDAO();

        List<Country> countries = CountryDAO.getAllCountries();
        System.out.println(countries);

        CountryDAO.addCountry(8,"Germany");

        CountryDAO.getCountryById(8);

        CountryDAO.updateCountry(new Country(8, "Austria"));

        CountryDAO.getCountryById(8);

        CountryDAO.deleteCountry(8);

        System.out.println(countries);
    }
}
