package com.solvd.it_company.dao;

import com.solvd.it_company.models.Teams;

import java.util.List;

public interface ITeamsDAO {
    Teams getTeamById(int id);

    List<Teams> getAllTeams();

    void addTeam(int id, String team_name);

    void updateTeam(Teams teams);

    void deleteTeam(int id);
}
