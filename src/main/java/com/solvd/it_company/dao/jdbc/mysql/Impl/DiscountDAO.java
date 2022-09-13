package com.solvd.it_company.dao.jdbc.mysql.Impl;

import com.solvd.it_company.connection.ConnectionUtil;
import com.solvd.it_company.dao.IDiscountDAO;
import com.solvd.it_company.models.Discount;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DiscountDAO implements IDiscountDAO {
    private static final Logger LOGGER = LogManager.getLogger(DiscountDAO.class);

    @Override
    public Discount getDiscountById(int id) {
        ResultSet resultSet = null;
        Statement statement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Discount WHERE id=" + id);
            if (resultSet.next()) {
                LOGGER.info(getDiscountById(resultSet));
                return getDiscountById(resultSet);
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

    private Discount getDiscountById(ResultSet resultSet) throws SQLException {
        Discount newDiscount = new Discount();
        newDiscount.setId(resultSet.getInt("id"));
        newDiscount.setDiscountName(resultSet.getString("discount_name"));
        newDiscount.setDiscountSuccess(resultSet.getBoolean("discount_success"));
        return newDiscount;
    }

    @Override
    public List<Discount> getAllDiscounts() {
        List<Discount> discounts = new LinkedList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM Discount");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                discounts.add(getDiscountById(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(resultSet);
            ConnectionUtil.close(preparedStatement);
            ConnectionUtil.close(connection);
        }
        return discounts;
    }

    @Override
    public void addDiscount(Discount discount) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO Discount VALUE(default, ?, ?)");
            preparedStatement.setString(1, discount.getDiscountName());
            preparedStatement.setBoolean(2, discount.getDiscountSuccess());
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
    public void updateDiscount(Discount discount) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("UPDATE Discount SET discount_name=?, " +
                    "discount_success=? WHERE id=?");
            preparedStatement.setString(1, discount.getDiscountName());
            preparedStatement.setBoolean(2, discount.getDiscountSuccess());
            preparedStatement.setInt(3, discount.getId());
            if (preparedStatement.executeUpdate() == 1) {
                LOGGER.info("Update process is successful: " + discount.getId() + " - " + discount.getDiscountName());
            } else
                LOGGER.info("Update process was failed: " + discount.getId() + " - " + discount.getDiscountName());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(preparedStatement);
            ConnectionUtil.close(connection);
        }
    }

    @Override
    public void deleteDiscount(int id) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM Discount WHERE id=" + id);
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
