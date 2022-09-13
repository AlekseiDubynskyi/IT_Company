package com.solvd.it_company.models;

public class City {
    private int id;
    private String city;
    private int countryId;

    public City() {
    }

    public City(String city, int countryId) {
        this.city = city;
        this.countryId = countryId;
    }

    public City(int id, String city, int countryId) {
        this.id = id;
        this.city = city;
        this.countryId = countryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", country id=" + countryId +
                '}';
    }
}
