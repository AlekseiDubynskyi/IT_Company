package com.solvd.it_company.models;

import java.util.Date;

public class Orders {
    private int id;
    private double price;
    private Date dateCreation;
    private String paymentType;
    private Date datePayment;
    private int customerId;
    private int teamId;
    private int discountId;
    private int serviceCategoryId;

    public Orders() {
    }

    public Orders(double price, Date dateCreation, String paymentType, Date datePayment, int customerId, int teamId, int discountId, int serviceCategoryId) {
        this.price = price;
        this.dateCreation = dateCreation;
        this.paymentType = paymentType;
        this.datePayment = datePayment;
        this.customerId = customerId;
        this.teamId = teamId;
        this.discountId = discountId;
        this.serviceCategoryId = serviceCategoryId;
    }

    public Orders(int id, double price, Date dateCreation, String paymentType, Date datePayment, int customerId, int teamId, int discountId, int serviceCategoryId) {
        this.id = id;
        this.price = price;
        this.dateCreation = dateCreation;
        this.paymentType = paymentType;
        this.datePayment = datePayment;
        this.customerId = customerId;
        this.teamId = teamId;
        this.discountId = discountId;
        this.serviceCategoryId = serviceCategoryId;
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

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Date getDatePayment() {
        return datePayment;
    }

    public void setDatePayment(Date datePayment) {
        this.datePayment = datePayment;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getDiscountId() {
        return discountId;
    }

    public void setDiscountId(int discountId) {
        this.discountId = discountId;
    }

    public int getServiceCategoryId() {
        return serviceCategoryId;
    }

    public void setServiceCategoryId(int serviceCategoryId) {
        this.serviceCategoryId = serviceCategoryId;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", price=" + price +
                ", date creation=" + dateCreation +
                ", payment type='" + paymentType + '\'' +
                ", date payment=" + datePayment +
                ", customer id=" + customerId +
                ", team id=" + teamId +
                ", discount id=" + discountId +
                ", service category id=" + serviceCategoryId +
                '}';
    }
}
