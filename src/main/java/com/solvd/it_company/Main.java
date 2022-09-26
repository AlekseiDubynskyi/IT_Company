package com.solvd.it_company;

import com.solvd.it_company.connection.ConnectionUtil;
import com.solvd.it_company.dao.jdbc.mysql.Impl.AddressesDAO;
import com.solvd.it_company.dao.jdbc.mysql.Impl.CustomersDAO;
import com.solvd.it_company.dao.mybatis.Impl.*;
import com.solvd.it_company.models.Addresses;
import com.solvd.it_company.services.MainPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    private final static Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        try (Connection connection = ConnectionUtil.getConnection()) {
            LOGGER.info(String.format("Connected to database %s" +
                    " successfully.", connection.getCatalog()));
        } catch (SQLException ex) {
            LOGGER.info(ex.getMessage());
        }


        MainPage.start();


//        AddressesMapperDAO addressesMapperDAO = new AddressesMapperDAO();
//
//        addressesMapperDAO.getAllAddresses();
//
//        addressesMapperDAO.addAddress(new Addresses("New Address", "Awesome District", "112233", 9));
//
//        addressesMapperDAO.updateAddress(new Addresses(12,"Best Address", "Beautiful district", "33333",9));
//
//        LOGGER.info(addressesMapperDAO.getAddressById(12));
//
//        addressesMapperDAO.deleteAddress(12);
//
//        addressesMapperDAO.getAllAddresses();
//
//
//
//        CategoriesMapperDAO categoriesMapperDAO = new CategoriesMapperDAO();
//        categoriesMapperDAO.getAllCategories();
//
//        CityMapperDAO cityMapperDAO = new CityMapperDAO();
//        cityMapperDAO.getAllCities();
//
//        CountryMapperDAO countryMapperDAO = new CountryMapperDAO();
//        countryMapperDAO.getAllCountries();
//
//        CustomerContactsMapperDAO customerContactsMapperDAO = new CustomerContactsMapperDAO();
//        customerContactsMapperDAO.getAllCustomerContacts();
    }
}
