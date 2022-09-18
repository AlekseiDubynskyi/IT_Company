package com.solvd.it_company.models;

import java.util.Objects;

public class Positions {
    private int id;
    private String position;

    public Positions() {
    }

    public Positions(String position) {
        this.position = position;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Positions positions = (Positions) o;
        return id == positions.id && position.equals(positions.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, position);
    }

    @Override
    public String toString() {
        return "Positions{" +
                "id=" + id +
                ", position='" + position + '\'' +
                '}';
    }
}
