package com.solvd.it_company.models;

public class Customer_types {
    private int id;
    private String customer_type;

    public Customer_types() {
    }

    public Customer_types(int id, String customer_type) {
        this.id = id;
        this.customer_type = customer_type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomer_type() {
        return customer_type;
    }

    public void setCustomer_type(String customer_type) {
        this.customer_type = customer_type;
    }

    @Override
    public String toString() {
        return "Customer_types{" +
                "id=" + id +
                ", customer_type='" + customer_type + '\'' +
                '}';
    }
}
