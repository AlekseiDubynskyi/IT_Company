package com.solvd.it_company.models;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city1 = (City) o;
        return id == city1.id && countryId == city1.countryId && city.equals(city1.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city, countryId);
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
