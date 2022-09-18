package com.solvd.it_company.models;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teams teams = (Teams) o;
        return id == teams.id && teamName.equals(teams.teamName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, teamName);
    }

    @Override
    public String toString() {
        return "Teams{" +
                "id=" + id +
                ", team_name='" + teamName + '\'' +
                '}';
    }
}
