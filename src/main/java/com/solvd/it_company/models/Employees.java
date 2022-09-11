package com.solvd.it_company.models;

public class Employees {
    private int id;
    private String first_name;
    private String last_name;
    private int position_id;
    private int contact_id;
    private int team_id;

    public Employees() {
    }

    public Employees(int id, String first_name, String last_name, int position_id, int contact_id, int team_id) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.position_id = position_id;
        this.contact_id = contact_id;
        this.team_id = team_id;
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

    public int getPosition_id() {
        return position_id;
    }

    public void setPosition_id(int position_id) {
        this.position_id = position_id;
    }

    public int getContact_id() {
        return contact_id;
    }

    public void setContact_id(int contact_id) {
        this.contact_id = contact_id;
    }

    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", position_id=" + position_id +
                ", contact_id=" + contact_id +
                ", team_id=" + team_id +
                '}';
    }
}
