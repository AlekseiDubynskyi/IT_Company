package com.solvd.it_company.models;

import java.util.Date;

public class Orders {
    private int id;
    private double price;
    private Date date_creation;
    private String payment_type;
    private Date date_payment;
    private Customers customers;
    private Teams teams;
    private Discount discount;
    private Service_category service_category;

    public Orders() {
    }

    public Orders(int id, double price, Date date_creation, String payment_type, Date date_payment, Customers customers, Teams teams, Discount discount, Service_category service_category) {
        this.id = id;
        this.price = price;
        this.date_creation = date_creation;
        this.payment_type = payment_type;
        this.date_payment = date_payment;
        this.customers = customers;
        this.teams = teams;
        this.discount = discount;
        this.service_category = service_category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    public Date getDate_payment() {
        return date_payment;
    }

    public void setDate_payment(Date date_payment) {
        this.date_payment = date_payment;
    }

    public Customers getCustomers() {
        return customers;
    }

    public void setCustomers(Customers customers) {
        this.customers = customers;
    }

    public Teams getTeams() {
        return teams;
    }

    public void setTeams(Teams teams) {
        this.teams = teams;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public Service_category getService_category() {
        return service_category;
    }

    public void setService_category(Service_category service_category) {
        this.service_category = service_category;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", price=" + price +
                ", date_creation=" + date_creation +
                ", payment_type='" + payment_type + '\'' +
                ", date_payment=" + date_payment +
                ", customers=" + customers +
                ", teams=" + teams +
                ", discount=" + discount +
                ", service_category=" + service_category +
                '}';
    }
}
