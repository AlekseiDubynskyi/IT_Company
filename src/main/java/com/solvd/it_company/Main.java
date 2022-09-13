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
    private final static Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        try (Connection connection = ConnectionUtil.getConnection()) {
            LOGGER.info(String.format("Connected to database %s"
                    + " successfully.", connection.getCatalog()));
        } catch (SQLException ex) {
            LOGGER.info(ex.getMessage());
        }

        ICountryDAO countryDAO = new CountryDAO();

        List<Country> countries = countryDAO.getAllCountries();
        countries.forEach(LOGGER::info);

        countryDAO.addCountry(8, "Germany");

        countryDAO.getCountryById(12);

        countryDAO.updateCountry(new Country(8, "Austria"));

        countryDAO.getCountryById(8);

        countryDAO.deleteCountry(8);

        countries.forEach(LOGGER::info);
    }
}
