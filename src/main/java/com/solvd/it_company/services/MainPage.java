package com.solvd.it_company.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class MainPage {
    private static final Logger LOGGER = LogManager.getLogger(MainPage.class);

    public static void start() {
        LOGGER.info("Hi, Dear User! Choose your next action:" + "\n" +
                "1) Join our company as an employee." + "\n" +
                "2) Join as a customer" + "\n" +
                "3) I'm administrator." + "\n" +
                "0) Exit." + "\n" + "\n" +
                "Enter your choice:");

        Scanner scanner = new Scanner(System.in);
        String choice;
        choice = scanner.nextLine();

        switch (choice) {
            case "1":
                EmployeePage.addEmployeeToDB();
                start();
                break;
            case "2":
                CustomerPage.addCustomerToDB();
                start();
                break;
            case "3":
                AdministratorPage.administratorLogin();
                start();
                break;
            case "0":
                System.exit(0);
            default:
                LOGGER.info("Please enter only the provided numbers.");
                start();
                break;
        }
    }
}
