package com.solvd.it_company.models;

import java.util.Objects;

public class Country {
    private int id;
    private String country;

    public Country() {
    }

    public Country(String country) {
        this.country = country;
    }

    public Country(int id, String country) {
        this.id = id;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country1 = (Country) o;
        return id == country1.id && country.equals(country1.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country);
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", country='" + country + '\'' +
                '}';
    }
}
