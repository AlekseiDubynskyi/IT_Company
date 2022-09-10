package com.solvd.it_company.models;

public class Positions {
    private int id;
    private String position;

    public Positions() {
    }

    public Positions(int id, String position) {
        this.id = id;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Positions{" +
                "id=" + id +
                ", position='" + position + '\'' +
                '}';
    }
}
