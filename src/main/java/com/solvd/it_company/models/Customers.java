package com.solvd.it_company.models;

public class Customers {
    private int id;
    private String customer_name;
    private int customer_type_id;
    private int customer_contact_id;

    public Customers() {
    }

    public Customers(int id, String customer_name, int customer_type_id, int customer_contact_id) {
        this.id = id;
        this.customer_name = customer_name;
        this.customer_type_id = customer_type_id;
        this.customer_contact_id = customer_contact_id;
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

    public int getCustomer_type_id() {
        return customer_type_id;
    }

    public void setCustomer_type_id(int customer_type_id) {
        this.customer_type_id = customer_type_id;
    }

    public int getCustomer_contact_id() {
        return customer_contact_id;
    }

    public void setCustomer_contact_id(int customer_contact_id) {
        this.customer_contact_id = customer_contact_id;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "id=" + id +
                ", customer_name='" + customer_name + '\'' +
                ", customer_type_id=" + customer_type_id +
                ", customer_contact_id=" + customer_contact_id +
                '}';
    }
}
