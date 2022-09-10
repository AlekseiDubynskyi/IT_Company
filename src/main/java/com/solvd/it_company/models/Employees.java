package com.solvd.it_company.models;

public class Employees {
    private int id;
    private String first_name;
    private String last_name;
    private Positions positions;
    private Employee_contacts employee_contacts;
    private Teams teams;

    public Employees() {
    }

    public Employees(int id, String first_name, String last_name, Positions positions, Employee_contacts employee_contacts, Teams teams) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.positions = positions;
        this.employee_contacts = employee_contacts;
        this.teams = teams;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Positions getPositions() {
        return positions;
    }

    public void setPositions(Positions positions) {
        this.positions = positions;
    }

    public Employee_contacts getEmployee_contacts() {
        return employee_contacts;
    }

    public void setEmployee_contacts(Employee_contacts employee_contacts) {
        this.employee_contacts = employee_contacts;
    }

    public Teams getTeams() {
        return teams;
    }

    public void setTeams(Teams teams) {
        this.teams = teams;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", positions=" + positions +
                ", employee_contacts=" + employee_contacts +
                ", teams=" + teams +
                '}';
    }
}
