package com.solvd.it_company.services;

import com.solvd.it_company.dao.jdbc.mysql.Impl.AddressesDAO;
import com.solvd.it_company.dao.jdbc.mysql.Impl.CityDAO;
import com.solvd.it_company.dao.jdbc.mysql.Impl.CountryDAO;
import com.solvd.it_company.models.Addresses;
import com.solvd.it_company.models.City;
import com.solvd.it_company.models.Country;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class AddLocationToDB {
    private static final Logger LOGGER = LogManager.getLogger(AddLocationToDB.class);
    public static int countryIdInDB;
    public static int cityIdInDB;
    public static int addressIdInDB;
    private static boolean countryStart = false;
    private static boolean cityStart = false;
    private static boolean addressStart = false;

    public static void addCountryToDB() {
        Scanner scanner = new Scanner(System.in);
        boolean countryValidation = false;
        Country country = new Country();
        CountryDAO countryDAO = new CountryDAO();

        do {
            LOGGER.info("What country do you live in?" + "\n" + "Enter the country:");
            String countryInput = scanner.nextLine();
            if (countryInput.matches("[A-Za-z]+")) {
                countryValidation = true;
                country.setCountry(countryInput);
                countryDAO.addCountry(country);
                if (!countryStart) {
                    countryStart = true;
                    countryIdInDB = 8;
                } else countryIdInDB = countryIdInDB + 1;
            } else {
                LOGGER.info("Please use a capital letter for the first letter of the country.");
            }
        } while (!countryValidation);
    }

    public static void addCityToDB() {
        Scanner scanner = new Scanner(System.in);
        boolean cityValidation = false;
        City city = new City();
        CityDAO cityDAO = new CityDAO();

        do {
            LOGGER.info("What city do you live in?" + "\n" + "Enter the city:");
            String cityInput = scanner.nextLine();
            if (cityInput.matches("[A-Z][a-z]+")) {
                cityValidation = true;
                city.setCity(cityInput);
                city.setCountryId(countryIdInDB);
                cityDAO.addCity(city);
                if (!cityStart) {
                    cityStart = true;
                    cityIdInDB = 12;
                } else cityIdInDB = cityIdInDB + 1;
            } else {
                LOGGER.info("Please use a capital letter for the first letter of the city.");
            }
        } while (!cityValidation);
    }

    public static void addAddressToDB() {
        Scanner scanner = new Scanner(System.in);
        Addresses addresses = new Addresses();
        AddressesDAO addressesDAO = new AddressesDAO();

        LOGGER.info("Add your address: ");
        String addressInput = scanner.nextLine();
        LOGGER.info("Add your district: ");
        String districtInput = scanner.nextLine();
        LOGGER.info("Add your postal code: ");
        String postalCodeInput = scanner.nextLine();

        addresses.setAddress(addressInput);
        addresses.setDistrict(districtInput);
        addresses.setPostalCode(postalCodeInput);
        addresses.setCityId(cityIdInDB);
        addressesDAO.addAddress(addresses);
        if (!addressStart) {
            addressStart = true;
            addressIdInDB = 12;
        } else addressIdInDB = addressIdInDB + 1;
    }
}

