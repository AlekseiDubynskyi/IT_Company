package com.solvd.it_company.models;

public class Employee_contacts {
    private int id;
    private String phone_number;
    private String email;
    private Addresses addresses;

    public Employee_contacts() {
    }

    public Employee_contacts(int id, String phone_number, String email, Addresses addresses) {
        this.id = id;
        this.phone_number = phone_number;
        this.email = email;
        this.addresses = addresses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Addresses getAddresses() {
        return addresses;
    }

    public void setAddresses(Addresses addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "Employee_contacts{" +
                "id=" + id +
                ", phone_number='" + phone_number + '\'' +
                ", email='" + email + '\'' +
                ", addresses=" + addresses +
                '}';
    }
}
