package com.solvd.it_company.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class MainPage {
    private static final Logger LOGGER = LogManager.getLogger(MainPage.class);

    public static void start() {
        LOGGER.info("Hi, Dear User! Choose your next action:" + "\n" +
                "1) Join our company as a employee." + "\n" +
                "2) Make an order." + "\n" +
                "3) I'm administrator." + "\n" + "\n" +
                "Enter your choice:");

        Scanner scanner = new Scanner(System.in);
        String choice;
        choice = scanner.nextLine();

        switch (choice) {
            case "1":
                EmployeePage.addEmployee();
                break;
            case "2":
                LOGGER.info("You are our customer");
                break;
            case "3":
                LOGGER.info("Proof it :-)");
                break;
            default:
                LOGGER.info("Please enter only the provided numbers.");
                start();
                break;
        }
    }
}
