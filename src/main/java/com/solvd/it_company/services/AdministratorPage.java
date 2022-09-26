package com.solvd.it_company.services;

import com.solvd.it_company.connection.ConnectionUtil;
import com.solvd.it_company.dao.jdbc.mysql.Impl.CustomersDAO;
import com.solvd.it_company.dao.jdbc.mysql.Impl.EmployeesDAO;
import com.solvd.it_company.dao.jdbc.mysql.Impl.OrdersDAO;
import com.solvd.it_company.dao.mybatis.Impl.OrdersMapperDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class AdministratorPage {
    private static final Logger LOGGER = LogManager.getLogger(AdministratorPage.class);

    public static void administratorLogin() {
        LOGGER.info("Enter the passcode to get admin roots. You can leave this page with '-' symbol" + "\n" +
                "Enter the passcode:");

        Scanner scanner = new Scanner(System.in);
        String passcode;
        passcode = scanner.nextLine();

        switch (passcode) {
            case "Admin":
                LOGGER.info("The passcode is correct. Administrator rights granted.");
                adminAccess();
                break;
            case "-":
                LOGGER.info("Leaving the Administrator Page");
                break;
            default:
                LOGGER.info("The entered passcode is incorrect.");
                administratorLogin();
                break;
        }
    }

    public static void adminAccess() {
        LOGGER.info("Dear Administrator, choose your next action:" + "\n" +
                "1) Show all employees" + "\n" +
                "2) Show all customers" + "\n" +
                "3) Show all orders" + "\n" +
                "0) Exit to the Main Page" + "\n" +
                "+) Create an Order" + "\n" + "\n" +
                "Enter your choice:");

        Scanner scanner = new Scanner(System.in);
        String choice;
        choice = scanner.nextLine();

        switch (choice) {
            case "1":
                EmployeesDAO employeesDAO = new EmployeesDAO();
                LOGGER.info(employeesDAO.getAllEmployees());
                adminAccess();
                break;
            case "2":
                CustomersDAO customersDAO = new CustomersDAO();
                LOGGER.info(customersDAO.getAllCustomers());
                adminAccess();
                break;
            case "3":
                OrdersMapperDAO ordersMapperDAO = new OrdersMapperDAO();
                ordersMapperDAO.getAllOrders();
                adminAccess();
                break;
            case "0":
                MainPage.start();
                break;
            case "+":
                OrderPage.addOrderToDB();
                adminAccess();
                break;
            default:
                LOGGER.info("Please enter only the provided numbers.");
                adminAccess();
                break;
        }
    }
}
