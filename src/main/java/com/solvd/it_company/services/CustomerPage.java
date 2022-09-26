package com.solvd.it_company.services;

import com.solvd.it_company.dao.jdbc.mysql.Impl.CustomerContactsDAO;
import com.solvd.it_company.dao.jdbc.mysql.Impl.CustomersDAO;
import com.solvd.it_company.models.CustomerContacts;
import com.solvd.it_company.models.Customers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class CustomerPage {
    private static final Logger LOGGER = LogManager.getLogger(CustomerPage.class);
    public static int customerContactIdInDB;
    private static boolean customerContactStart = false;

    public static void addCustomerToDB() {
        Scanner scanner = new Scanner(System.in);
        boolean customerNameValidation = false;
        boolean customerTypeValidation = false;
        Customers customers = new Customers();
        CustomersDAO customersDAO = new CustomersDAO();

        do {
            LOGGER.info("Who are you?" + "\n" +
                    "1) Commercial company" + "\n" +
                    "2) Government agency" + "\n" +
                    "3) Individual" + "\n" +
                    "4) Private Company" + "\n" + "\n" +
                    "Enter your type:");
            String customerTypeInput = scanner.nextLine();
            switch (customerTypeInput) {
                case "1":
                    customers.setCustomerTypeId(1);
                    customerTypeValidation = true;
                    break;
                case "2":
                    customers.setCustomerTypeId(2);
                    customerTypeValidation = true;
                    break;
                case "3":
                    customers.setCustomerTypeId(3);
                    customerTypeValidation = true;
                    break;
                case "4":
                    customers.setCustomerTypeId(4);
                    customerTypeValidation = true;
                    break;
                default:
                    LOGGER.info("Please enter only one of the provided options.");
            }
        } while (!customerTypeValidation);

        do {
            LOGGER.info("Enter your name or the name of your company: ");
            String customerNameInput = scanner.nextLine();
            if (customerNameInput.matches("[A-Za-z]+")) {
                customers.setCustomerName(customerNameInput);
                customerNameValidation = true;
            } else {
                LOGGER.info("Please use the capital letter for the first letter.");
            }
        } while (!customerNameValidation);

        AddLocationToDB.addCountryToDB();
        AddLocationToDB.addCityToDB();
        AddLocationToDB.addAddressToDB();

        addCustomerContactsToDB();
        customers.setCustomerContactId(customerContactIdInDB);

        customersDAO.addCustomer(new Customers(customers.getCustomerName(), customers.getCustomerTypeId(), customers.getCustomerContactId()));
    }

    public static void addCustomerContactsToDB() {
        Scanner scanner = new Scanner(System.in);
        CustomerContacts customerContacts = new CustomerContacts();
        CustomerContactsDAO customerContactsDAO = new CustomerContactsDAO();

        LOGGER.info("Enter the name of responsible person of your company (or your name if you are individual): ");
        String responsiblePersonInput = scanner.nextLine();
        LOGGER.info("Enter your phone number: ");
        String phoneNumberInput = scanner.nextLine();
        LOGGER.info("Enter your email: ");
        String emailInput = scanner.nextLine();

        customerContacts.setResponsiblePersonName(responsiblePersonInput);
        customerContacts.setPhoneNumber(phoneNumberInput);
        customerContacts.setEmail(emailInput);
        customerContacts.setAddressId(AddLocationToDB.addressIdInDB);
        customerContactsDAO.addCustomerContact(customerContacts);
        if (!customerContactStart) {
            customerContactStart = true;
            customerContactIdInDB = 3;
        } else customerContactIdInDB = customerContactIdInDB + 1;
    }
}
