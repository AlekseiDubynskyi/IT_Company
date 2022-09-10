package com.solvd.it_company.models;

public class Addresses {
    private int id;
    private String address;
    private String district;
    private String postal_code;
    private City city;

    public Addresses() {
    }

    public Addresses(int id, String address, String district, String postal_code, City city) {
        this.id = id;
        this.address = address;
        this.district = district;
        this.postal_code = postal_code;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Addresses{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", district='" + district + '\'' +
                ", postal_code='" + postal_code + '\'' +
                ", city=" + city +
                '}';
    }
}
