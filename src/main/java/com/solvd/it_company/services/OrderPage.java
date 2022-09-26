package com.solvd.it_company.services;

import com.solvd.it_company.dao.jdbc.mysql.Impl.*;
import com.solvd.it_company.models.Orders;
import com.solvd.it_company.models.ServiceCategory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Scanner;

public class OrderPage {
    private static final Logger LOGGER = LogManager.getLogger(OrderPage.class);
    public static Timestamp getDate;
    public static int serviceCategoryIdToDB;
    private static float priceInput;
    private static String paymentTypeInput;
    private static int teamIdInput;
    private static int customerIdInput;
    private static int discountIdInput;
    private static boolean serviceCategoryStart = false;

    public static void addOrderToDB() {
        Scanner scanner = new Scanner(System.in);
        boolean paymentValidation = false;
        Orders orders = new Orders();
        OrdersDAO ordersDAO = new OrdersDAO();

        getDate();
        orders.setDateCreation(getDate);

        addCustomer();
        orders.setCustomerId(customerIdInput);

        addServiceCategoryToDB();
        orders.setServiceCategoryId(serviceCategoryIdToDB);

        addTeam();
        orders.setTeamId(teamIdInput);

        paymentProcess();
        orders.setPaymentType(paymentTypeInput);

        addDiscount();
        orders.setDiscountId(discountIdInput);
        orders.setPrice(priceInput);

        do {
            LOGGER.info("Payment process!");
            LOGGER.info("Payment amount for the order is $" + priceInput);
            LOGGER.info("Do you want to pay for the order? (yes/no)");
            String input = scanner.nextLine();
            switch (input) {
                case ("yes"):
                    paymentValidation = true;
                    getDate();
                    orders.setDatePayment(getDate);
                    break;
                case ("no"):
                    paymentValidation = true;
                    getDate = null;
                    break;
                default:
                    LOGGER.info("Please enter 'yes' or 'no'");
                    break;
            }
        } while (!paymentValidation);

        ordersDAO.addOrder(new Orders(orders.getPrice(), orders.getDateCreation(), orders.getPaymentType(), orders.getDatePayment(), orders.getCustomerId(), orders.getTeamId(), orders.getDiscountId(), orders.getServiceCategoryId()));
    }

    public static void addCustomer() {
        Scanner scanner = new Scanner(System.in);
        CustomersDAO customersDAO = new CustomersDAO();
        boolean customerValidation = false;
        LOGGER.info(customersDAO.getAllCustomers());

        do {
            LOGGER.info("Enter the ID of the customer: ");
            String input = scanner.nextLine();
            if (input.matches("[0-9]+")) {
                customerIdInput = Integer.parseInt(input);
                customerValidation = true;
            } else {
                LOGGER.info("Please enter one ID of the provided customers.");
            }
        } while (!customerValidation);
    }

    public static void addServiceCategoryToDB() {
        Scanner scanner = new Scanner(System.in);
        boolean serviceValidation = false;
        boolean categoryValidation = false;
        ServiceCategory serviceCategory = new ServiceCategory();
        ServiceCategoryDAO serviceCategoryDAO = new ServiceCategoryDAO();

        ServicesDAO servicesDAO = new ServicesDAO();
        LOGGER.info(servicesDAO.getAllServices());
        do {
            LOGGER.info("Enter the ID of the needed service: ");
            String serviceInput = scanner.nextLine();
            if (serviceInput.matches("[1-4]")) {
                serviceCategory.setServiceId(Integer.parseInt(serviceInput));
                serviceValidation = true;
            } else {
                LOGGER.info("Please use one of the provided services.");
            }
        } while (!serviceValidation);


        CategoriesDAO categoriesDAO = new CategoriesDAO();
        LOGGER.info(categoriesDAO.getAllCategories());
        do {
            LOGGER.info("Enter the ID of the needed category: ");
            String categoryInput = scanner.nextLine();
            if (categoryInput.matches("[1-5]")) {
                serviceCategory.setCategoryId(Integer.parseInt(categoryInput));
                categoryValidation = true;
            } else {
                LOGGER.info("Please use one of the provided services.");
            }
        } while (!categoryValidation);

        serviceCategoryDAO.addServiceCategory(serviceCategory);

        if (!serviceCategoryStart) {
            serviceCategoryStart = true;
            serviceCategoryIdToDB = 21;
        } else serviceCategoryIdToDB = serviceCategoryIdToDB + 1;
    }

    public static void addTeam() {
        Scanner scanner = new Scanner(System.in);
        boolean teamValidation = false;
        do {
            LOGGER.info("Choose wished team: " + "\n" +
                    "1) Java lovers" + "\n" +
                    "2) Top communicators" + "\n" +
                    "3) Mega productive team" + "\n" +
                    "4) Best team" + "\n" + "\n" +
                    "Your choice: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    teamIdInput = 1;
                    teamValidation = true;
                    break;
                case "2":
                    teamIdInput = 2;
                    teamValidation = true;
                    break;
                case "3":
                    teamIdInput = 3;
                    teamValidation = true;
                    break;
                case "4":
                    teamIdInput = 4;
                    teamValidation = true;
                    break;
                default:
                    LOGGER.info("Please enter only one of the provided teams.");
            }
        } while (!teamValidation);
    }

    public static void addDiscount() {
        Scanner scanner = new Scanner(System.in);
        DiscountDAO discountDAO = new DiscountDAO();
        LOGGER.info(discountDAO.getAllDiscounts() + "\n");

        LOGGER.info("You can use a discount for 3%. If you don't want to use it write the word 'skip'");
        LOGGER.info("Enter the ID of the discount or skip this stage: ");
        String input = scanner.nextLine();
        switch (input) {
            case ("1"):
            case ("2"):
            case ("3"):
                discountIdInput = Integer.parseInt(input);
                priceInput = (float) (priceInput - (priceInput * 0.03));
                break;
            case ("skip"):
                discountIdInput = 0;
                break;
            default:
                LOGGER.info("Please enter one ID of the provided discounts.");
                addDiscount();
                break;
        }
    }

    public static void paymentProcess() {
        Scanner scanner = new Scanner(System.in);
        boolean priceValidation = false;
        boolean paymentTypeValidation = false;

        do {
            LOGGER.info("Enter the price of the order ($): ");
            String input = scanner.nextLine();
            if (input.matches("[0-9]+")) {
                priceInput = Integer.parseInt(input);
                priceValidation = true;
            } else {
                LOGGER.info("Please enter the price only in numbers.");
            }
        } while (!priceValidation);

        do {
            LOGGER.info("Enter payment type: ");
            String input = scanner.nextLine();
            if (input.matches("[A-z][a-z]+")) {
                paymentTypeInput = input;
                paymentTypeValidation = true;
            } else {
                LOGGER.info("Please enter payment type only with letters.");
            }
        } while (!paymentTypeValidation);
    }

    public static void getDate() {
        Date date = new Date();
        Timestamp sqlTime = new Timestamp(date.getTime());
        getDate = sqlTime;
    }
}