package com.solvd.it_company.dao.jdbc.mysql.Impl;

import com.solvd.it_company.connection.ConnectionUtil;
import com.solvd.it_company.dao.ITeamsDAO;
import com.solvd.it_company.models.Positions;
import com.solvd.it_company.models.Teams;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class TeamsDAO implements ITeamsDAO {
    List<Teams> teams = new LinkedList<>();
    @Override
    public Teams getTeamById(int id) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Teams WHERE id=" + id);
            if (resultSet.next()) {
                System.out.println(getTeamById(resultSet));
                return getTeamById(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Teams getTeamById(ResultSet resultSet) throws SQLException{
        Teams newTeam = new Teams();
        newTeam.setId(resultSet.getInt("id"));
        newTeam.setTeam_name(resultSet.getString("team_name"));
        return newTeam;
    }

    @Override
    public List<Teams> getAllTeams() {
        PreparedStatement preparedStatement;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM Teams");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                teams.add(getTeamById(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teams;
    }

    @Override
    public void addTeam(int id, String team_name) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Teams VALUE(default, ?)");
            preparedStatement.setString(1, team_name);
            if (preparedStatement.executeUpdate() == 1) {
                System.out.println("Insertion is successful.");
            } else
                System.out.println("Insertion was failed.");
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    @Override
    public void updateTeam(Teams teams) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Teams SET team_name=? WHERE id=?");
            preparedStatement.setString(1, teams.getTeam_name());
            preparedStatement.setInt(2, teams.getId());
            if (preparedStatement.executeUpdate() == 1) {
                System.out.println("Update process is successful: " + teams.getId() + "-" + teams.getTeam_name());
            } else
                System.out.println("Update process was failed: " + teams.getId() + "-" + teams.getTeam_name());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTeam(int id) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Teams WHERE id=" + id);
            if (preparedStatement.executeUpdate() == 1) {
                System.out.println("Delete process is successful.");
            } else
                System.out.println("Delete process was failed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
