package com.solvd.it_company.dao.jdbc.mysql.Impl;

import com.solvd.it_company.connection.ConnectionUtil;
import com.solvd.it_company.dao.ITeamsDAO;
import com.solvd.it_company.models.Teams;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class TeamsDAO implements ITeamsDAO {
    private static final Logger LOGGER = LogManager.getLogger(TeamsDAO.class);

    @Override
    public Teams getTeamById(int id) {
        ResultSet resultSet = null;
        Statement statement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Teams WHERE id=" + id);
            if (resultSet.next()) {
                LOGGER.info(getTeamById(resultSet));
                return getTeamById(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(resultSet);
            ConnectionUtil.close(statement);
            ConnectionUtil.close(connection);
        }
        return null;
    }

    private Teams getTeamById(ResultSet resultSet) throws SQLException {
        Teams newTeam = new Teams();
        newTeam.setId(resultSet.getInt("id"));
        newTeam.setTeamName(resultSet.getString("team_name"));
        return newTeam;
    }

    @Override
    public List<Teams> getAllTeams() {
        List<Teams> teams = new LinkedList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM Teams");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                teams.add(getTeamById(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(resultSet);
            ConnectionUtil.close(preparedStatement);
            ConnectionUtil.close(connection);
        }
        return teams;
    }

    @Override
    public void addTeam(Teams teams) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO Teams VALUE(default, ?)");
            preparedStatement.setString(1, teams.getTeamName());
            if (preparedStatement.executeUpdate() == 1) {
                LOGGER.info("Insertion is successful.");
            } else
                LOGGER.info("Insertion was failed.");
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());
        } finally {
            ConnectionUtil.close(preparedStatement);
            ConnectionUtil.close(connection);
        }
    }

    @Override
    public void updateTeam(Teams teams) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("UPDATE Teams SET team_name=? WHERE id=?");
            preparedStatement.setString(1, teams.getTeamName());
            preparedStatement.setInt(2, teams.getId());
            if (preparedStatement.executeUpdate() == 1) {
                LOGGER.info("Update process is successful: " + teams.getId() + " - " + teams.getTeamName());
            } else
                LOGGER.info("Update process was failed: " + teams.getId() + " - " + teams.getTeamName());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(preparedStatement);
            ConnectionUtil.close(connection);
        }
    }

    @Override
    public void deleteTeam(int id) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM Teams WHERE id=" + id);
            if (preparedStatement.executeUpdate() == 1) {
                LOGGER.info("Delete process is successful.");
            } else
                LOGGER.info("Delete process was failed.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(preparedStatement);
            ConnectionUtil.close(connection);
        }
    }
}
