package com.solvd.it_company.models;

public class Customers {
    private int id;
    private String customer_name;
    private Customer_types customer_types;
    private Customer_contacts customer_contacts;

    public Customers() {
    }

    public Customers(int id, String customer_name, Customer_types customer_types, Customer_contacts customer_contacts) {
        this.id = id;
        this.customer_name = customer_name;
        this.customer_types = customer_types;
        this.customer_contacts = customer_contacts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public Customer_types getCustomer_types() {
        return customer_types;
    }

    public void setCustomer_types(Customer_types customer_types) {
        this.customer_types = customer_types;
    }

    public Customer_contacts getCustomer_contacts() {
        return customer_contacts;
    }

    public void setCustomer_contacts(Customer_contacts customer_contacts) {
        this.customer_contacts = customer_contacts;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "id=" + id +
                ", customer_name='" + customer_name + '\'' +
                ", customer_types=" + customer_types +
                ", customer_contacts=" + customer_contacts +
                '}';
    }
}
