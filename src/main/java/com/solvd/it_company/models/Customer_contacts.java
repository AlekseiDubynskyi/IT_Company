package com.solvd.it_company.models;

public class Customer_contacts {
    private int id;
    private String responsible_person_name;
    private String phone_number;
    private String email;
    private int address_id;

    public Customer_contacts() {
    }

    public Customer_contacts(int id, String responsible_person_name, String phone_number, String email, int address_id) {
        this.id = id;
        this.responsible_person_name = responsible_person_name;
        this.phone_number = phone_number;
        this.email = email;
        this.address_id = address_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResponsible_person_name() {
        return responsible_person_name;
    }

    public void setResponsible_person_name(String responsible_person_name) {
        this.responsible_person_name = responsible_person_name;
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

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    @Override
    public String toString() {
        return "Customer_contacts{" +
                "id=" + id +
                ", responsible_person_name='" + responsible_person_name + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", email='" + email + '\'' +
                ", address_id=" + address_id +
                '}';
    }
}
