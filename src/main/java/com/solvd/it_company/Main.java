package com.solvd.it_company;

import com.solvd.it_company.connection.ConnectionUtil;
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
    }
}
