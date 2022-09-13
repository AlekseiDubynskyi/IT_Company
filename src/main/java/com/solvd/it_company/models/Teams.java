package com.solvd.it_company.models;

public class Teams {
    private int id;
    private String teamName;

    public Teams() {
    }

    public Teams(String teamName) {
        this.teamName = teamName;
    }

    public Teams(int id, String teamName) {
        this.id = id;
        this.teamName = teamName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public String toString() {
        return "Teams{" +
                "id=" + id +
                ", team_name='" + teamName + '\'' +
                '}';
    }
}
