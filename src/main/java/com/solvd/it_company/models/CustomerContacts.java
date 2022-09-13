package com.solvd.it_company.models;

public class CustomerContacts {
    private int id;
    private String responsiblePersonName;
    private String phoneNumber;
    private String email;
    private int addressId;

    public CustomerContacts() {
    }

    public CustomerContacts(String responsiblePersonName, String phoneNumber, String email, int addressId) {
        this.responsiblePersonName = responsiblePersonName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.addressId = addressId;
    }

    public CustomerContacts(int id, String responsiblePersonName, String phoneNumber, String email, int addressId) {
        this.id = id;
        this.responsiblePersonName = responsiblePersonName;
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

    public String getResponsiblePersonName() {
        return responsiblePersonName;
    }

    public void setResponsiblePersonName(String responsiblePersonName) {
        this.responsiblePersonName = responsiblePersonName;
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
        return "Customer_contacts{" +
                "id=" + id +
                ", responsible person name='" + responsiblePersonName + '\'' +
                ", phone number='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address id=" + addressId +
                '}';
    }
}
