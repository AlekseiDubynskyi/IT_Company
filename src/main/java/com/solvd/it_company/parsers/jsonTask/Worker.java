package com.solvd.it_company.parsers.jsonTask;

import java.util.Arrays;

public class Worker {
    private String id;
    private String fullName;
    private String position;
    private String country;
    private String[] languages;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", position='" + position + '\'' +
                ", country='" + country + '\'' +
                ", languages=" + Arrays.toString(languages) +
                '}';
    }
}