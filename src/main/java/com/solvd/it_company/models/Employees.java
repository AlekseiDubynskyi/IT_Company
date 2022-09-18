package com.solvd.it_company.models;

import java.util.Objects;

public class Employees {
    private int id;
    private String firstName;
    private String lastName;
    private int positionId;
    private int contactId;
    private int teamId;

    public Employees() {
    }

    public Employees(String firstName, String lastName, int positionId, int contactId, int teamId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.positionId = positionId;
        this.contactId = contactId;
        this.teamId = teamId;
    }

    public Employees(int id, String firstName, String lastName, int positionId, int contactId, int teamId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.positionId = positionId;
        this.contactId = contactId;
        this.teamId = teamId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employees employees = (Employees) o;
        return id == employees.id && positionId == employees.positionId && contactId == employees.contactId && teamId == employees.teamId && firstName.equals(employees.firstName) && lastName.equals(employees.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, positionId, contactId, teamId);
    }

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", first name='" + firstName + '\'' +
                ", last name='" + lastName + '\'' +
                ", position id=" + positionId +
                ", contact id=" + contactId +
                ", team id=" + teamId +
                '}';
    }
}
