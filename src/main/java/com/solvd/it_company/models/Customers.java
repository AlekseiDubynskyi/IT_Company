package com.solvd.it_company.models;

import java.util.Objects;

public class Customers {
    private int id;
    private String customerName;
    private int customerTypeId;
    private int customerContactId;

    public Customers() {
    }

    public Customers(String customerName, int customerTypeId, int customerContactId) {
        this.customerName = customerName;
        this.customerTypeId = customerTypeId;
        this.customerContactId = customerContactId;
    }

    public Customers(int id, String customerName, int customerTypeId, int customerContactId) {
        this.id = id;
        this.customerName = customerName;
        this.customerTypeId = customerTypeId;
        this.customerContactId = customerContactId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(int customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public int getCustomerContactId() {
        return customerContactId;
    }

    public void setCustomerContactId(int customerContactId) {
        this.customerContactId = customerContactId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customers customers = (Customers) o;
        return id == customers.id && customerTypeId == customers.customerTypeId && customerContactId == customers.customerContactId && customerName.equals(customers.customerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerName, customerTypeId, customerContactId);
    }

    @Override
    public String toString() {
        return "Customers{" +
                "id=" + id +
                ", customer name='" + customerName + '\'' +
                ", customer type id=" + customerTypeId +
                ", customer contact id=" + customerContactId +
                '}';
    }
}
