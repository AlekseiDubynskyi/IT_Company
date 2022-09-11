package com.solvd.it_company.models;

public class City {
    private int id;
    private String city;
    private int country_id;

    public City() {
    }

    public City(int id, String city, int country_id) {
        this.id = id;
        this.city = city;
        this.country_id = country_id;
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

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", country_id=" + country_id +
                '}';
    }
}
