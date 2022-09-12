package com.solvd.it_company.dao.jdbc.mysql.Impl;

import com.solvd.it_company.connection.ConnectionUtil;
import com.solvd.it_company.dao.IPositionsDAO;
import com.solvd.it_company.models.Positions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class PositionsDAO implements IPositionsDAO {
    private static final Logger LOGGER = LogManager.getLogger(PositionsDAO.class);
    List<Positions> positions = new LinkedList<>();

    @Override
    public Positions getPositionById(int id) {
        ResultSet resultSet = null;
        Statement statement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Positions WHERE id=" + id);
            if (resultSet.next()) {
                LOGGER.info(getPositionById(resultSet));
                return getPositionById(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (statement != null) statement.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (connection != null) connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return null;
    }

    private Positions getPositionById(ResultSet resultSet) throws SQLException {
        Positions newPosition = new Positions();
        newPosition.setId(resultSet.getInt("id"));
        newPosition.setPosition(resultSet.getString("position"));
        return newPosition;
    }

    @Override
    public List<Positions> getAllPositions() {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM Positions");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                positions.add(getPositionById(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (connection != null) connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (resultSet != null) resultSet.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return positions;
    }

    @Override
    public void addPosition(int id, String position) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO Positions VALUE(default, ?)");
            preparedStatement.setString(1, position);
            if (preparedStatement.executeUpdate() == 1) {
                LOGGER.info("Insertion is successful.");
            } else
                LOGGER.info("Insertion was failed.");
        } catch (SQLException e) {
            e.getMessage();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (connection != null) connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    @Override
    public void updatePosition(Positions positions) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("UPDATE Positions SET position=? WHERE id=?");
            preparedStatement.setString(1, positions.getPosition());
            preparedStatement.setInt(2, positions.getId());
            if (preparedStatement.executeUpdate() == 1) {
                LOGGER.info("Update process is successful: " + positions.getId() + " - " + positions.getPosition());
            } else
                LOGGER.info("Update process was failed: " + positions.getId() + " - " + positions.getPosition());
        } catch (SQLException e) {
            e.printStackTrace();
        }  finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (connection != null) connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    @Override
    public void deletePosition(int id) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM Positions WHERE id=" + id);
            if (preparedStatement.executeUpdate() == 1) {
                LOGGER.info("Delete process is successful.");
            } else
                LOGGER.info("Delete process was failed.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            try {
                if (connection != null) connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
