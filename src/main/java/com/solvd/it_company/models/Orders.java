package com.solvd.it_company.models;

import java.util.Date;

public class Orders {
    private int id;
    private double price;
    private Date date_creation;
    private String payment_type;
    private Date date_payment;
    private int customer_id;
    private int team_id;
    private int discount_id;
    private int service_category_id;

    public Orders() {
    }

    public Orders(int id, double price, Date date_creation, String payment_type, Date date_payment, int customer_id, int team_id, int discount_id, int service_category_id) {
        this.id = id;
        this.price = price;
        this.date_creation = date_creation;
        this.payment_type = payment_type;
        this.date_payment = date_payment;
        this.customer_id = customer_id;
        this.team_id = team_id;
        this.discount_id = discount_id;
        this.service_category_id = service_category_id;
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

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }

    public int getDiscount_id() {
        return discount_id;
    }

    public void setDiscount_id(int discount_id) {
        this.discount_id = discount_id;
    }

    public int getService_category_id() {
        return service_category_id;
    }

    public void setService_category_id(int service_category_id) {
        this.service_category_id = service_category_id;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", price=" + price +
                ", date_creation=" + date_creation +
                ", payment_type='" + payment_type + '\'' +
                ", date_payment=" + date_payment +
                ", customer_id=" + customer_id +
                ", team_id=" + team_id +
                ", discount_id=" + discount_id +
                ", service_category_id=" + service_category_id +
                '}';
    }
}
