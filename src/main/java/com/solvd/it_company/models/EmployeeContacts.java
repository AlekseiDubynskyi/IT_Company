package com.solvd.it_company.models;

public class EmployeeContacts {
    private int id;
    private String phoneNumber;
    private String email;
    private int addressId;

    public EmployeeContacts() {
    }

    public EmployeeContacts(String phoneNumber, String email, int addressId) {
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.addressId = addressId;
    }

    public EmployeeContacts(int id, String phoneNumber, String email, int addressId) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.addressId = addressId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    @Override
    public String toString() {
        return "Employee_contacts{" +
                "id=" + id +
                ", phone number='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address id=" + addressId +
                '}';
    }
}
