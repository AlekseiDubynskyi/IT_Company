package com.solvd.it_company.dao.jdbc.mysql.Impl;

import com.solvd.it_company.connection.ConnectionUtil;
import com.solvd.it_company.dao.IPositionsDAO;
import com.solvd.it_company.models.Positions;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class PositionsDAO implements IPositionsDAO {
    List<Positions> positions = new LinkedList<>();

    @Override
    public Positions getPositionById(int id) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Positions WHERE id=" + id);
            if (resultSet.next()) {
                System.out.println(getPositionById(resultSet));
                return getPositionById(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Positions getPositionById(ResultSet resultSet) throws SQLException{
        Positions newPosition = new Positions();
        newPosition.setId(resultSet.getInt("id"));
        newPosition.setPosition(resultSet.getString("position"));
        return newPosition;
    }

    @Override
    public List<Positions> getAllPositions() {
        PreparedStatement preparedStatement;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM Positions");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                positions.add(getPositionById(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return positions;
    }

    @Override
    public void addPosition(int id, String position) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Positions VALUE(default, ?)");
            preparedStatement.setString(1, position);
            if (preparedStatement.executeUpdate() == 1) {
                System.out.println("Insertion is successful.");
            } else
                System.out.println("Insertion was failed.");
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    @Override
    public void updatePosition(Positions positions) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Positions SET position=? WHERE id=?");
            preparedStatement.setString(1, positions.getPosition());
            preparedStatement.setInt(2, positions.getId());
            if (preparedStatement.executeUpdate() == 1) {
                System.out.println("Update process is successful: " + positions.getId() + "-" + positions.getPosition());
            } else
                System.out.println("Update process was failed: " + positions.getId() + "-" + positions.getPosition());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletePosition(int id) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Positions WHERE id=" + id);
            if (preparedStatement.executeUpdate() == 1) {
                System.out.println("Delete process is successful.");
            } else
                System.out.println("Delete process was failed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
