package com.solvd.it_company.models;

public class Teams {
    private int id;
    private String team_name;

    public Teams() {
    }

    public Teams(int id, String team_name) {
        this.id = id;
        this.team_name = team_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    @Override
    public String toString() {
        return "Teams{" +
                "id=" + id +
                ", team_name='" + team_name + '\'' +
                '}';
    }
}
