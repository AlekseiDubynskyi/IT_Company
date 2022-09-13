package com.solvd.it_company.sax_task;

public class AddressesSAX {
    private int id;
    private String street;
    private String district;
    private String postal_code;
    private String city;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "AddressesSAX{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", district='" + district + '\'' +
                ", postal_code='" + postal_code + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}

