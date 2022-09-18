package com.solvd.it_company.models;

import java.util.Objects;

public class CustomerTypes {
    private int id;
    private String customerType;

    public CustomerTypes() {
    }

    public CustomerTypes(String customerType) {
        this.customerType = customerType;
    }

    public CustomerTypes(int id, String customerType) {
        this.id = id;
        this.customerType = customerType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerTypes that = (CustomerTypes) o;
        return id == that.id && customerType.equals(that.customerType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerType);
    }

    @Override
    public String toString() {
        return "Customer_types{" +
                "id=" + id +
                ", customer type='" + customerType + '\'' +
                '}';
    }
}
