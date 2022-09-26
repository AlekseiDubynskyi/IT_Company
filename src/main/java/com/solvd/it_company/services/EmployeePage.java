package com.solvd.it_company.services;

import com.solvd.it_company.dao.jdbc.mysql.Impl.EmployeeContactsDAO;
import com.solvd.it_company.dao.jdbc.mysql.Impl.EmployeesDAO;
import com.solvd.it_company.models.EmployeeContacts;
import com.solvd.it_company.models.Employees;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class EmployeePage {
    private static final Logger LOGGER = LogManager.getLogger(EmployeePage.class);
    public static int employeeContactIdInDB;
    private static boolean employeeContactStart = false;

    public static void addEmployeeToDB() {
        Scanner scanner = new Scanner(System.in);
        boolean firstnameValidation = false;
        boolean lastnameValidation = false;
        boolean positionValidation = false;
        boolean teamValidation = false;
        Employees employees = new Employees();
        EmployeesDAO employeesDAO = new EmployeesDAO();

        do {
            LOGGER.info("Enter your first name: ");
            String firstName = scanner.nextLine();
            if (firstName.matches("[A-Z][a-z]+")) {
                employees.setFirstName(firstName);
                firstnameValidation = true;
            } else {
                LOGGER.info("Please use a capital letter for the first letter of the first name.");
            }
        } while (!firstnameValidation);

        do {
            LOGGER.info("Enter your last name: ");
            String lastName = scanner.nextLine();
            if (lastName.matches("[A-Z][a-z]+")) {
                employees.setLastName(lastName);
                lastnameValidation = true;
            } else {
                LOGGER.info("Please use a capital letter for the first letter of the last name.");
            }
        } while (!lastnameValidation);

        do {
            LOGGER.info("Enter your position: " + "\n" +
                    "1) Manager" + "\n" +
                    "2) QA" + "\n" +
                    "3) Developer" + "\n" +
                    "4) Designer" + "\n" + "\n" +
                    "Enter your position");
            String position = scanner.nextLine();
            switch (position) {
                case "1":
                    employees.setPositionId(1);
                    positionValidation = true;
                    break;
                case "2":
                    employees.setPositionId(2);
                    positionValidation = true;
                    break;
                case "3":
                    employees.setPositionId(3);
                    positionValidation = true;
                    break;
                case "4":
                    employees.setPositionId(4);
                    positionValidation = true;
                    break;
                default:
                    LOGGER.info("Please enter only one of the provided positions.");
            }
        } while (!positionValidation);

        AddLocationToDB.addCountryToDB();
        AddLocationToDB.addCityToDB();
        AddLocationToDB.addAddressToDB();

        addEmployeeContactsToDB();
        employees.setContactId(employeeContactIdInDB);

        do {
            LOGGER.info("Choose your team: " + "\n" +
                    "1) Java lovers" + "\n" +
                    "2) Top communicators" + "\n" +
                    "3) Mega productive team" + "\n" +
                    "4) Best team" + "\n" + "\n" +
                    "Your choice: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    employees.setTeamId(1);
                    teamValidation = true;
                    break;
                case "2":
                    employees.setTeamId(2);
                    teamValidation = true;
                    break;
                case "3":
                    employees.setTeamId(3);
                    teamValidation = true;
                    break;
                case "4":
                    employees.setTeamId(4);
                    teamValidation = true;
                    break;
                default:
                    LOGGER.info("Please enter only one of the provided teams.");
            }
        } while (!teamValidation);

        employeesDAO.addEmployee(new Employees(employees.getFirstName(), employees.getLastName(), employees.getPositionId(), employees.getContactId(), employees.getTeamId()));
    }

    public static void addEmployeeContactsToDB() {
        Scanner scanner = new Scanner(System.in);
        EmployeeContacts employeeContacts = new EmployeeContacts();
        EmployeeContactsDAO employeeContactsDAO = new EmployeeContactsDAO();

        LOGGER.info("Enter your phone number: ");
        String phoneNumberInput = scanner.nextLine();
        LOGGER.info("Enter your email: ");
        String emailInput = scanner.nextLine();

        employeeContacts.setPhoneNumber(phoneNumberInput);
        employeeContacts.setEmail(emailInput);
        employeeContacts.setAddressId(AddLocationToDB.addressIdInDB);
        employeeContactsDAO.addEmployeeContact(employeeContacts);
        if (!employeeContactStart) {
            employeeContactStart = true;
            employeeContactIdInDB = 10;
        } else employeeContactIdInDB = employeeContactIdInDB + 1;
    }
}
