package com.solvd.it_company.dao.jdbc.mysql.Impl;

import com.solvd.it_company.connection.ConnectionUtil;
import com.solvd.it_company.dao.IDiscountDAO;
import com.solvd.it_company.models.Discount;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DiscountDAO implements IDiscountDAO {
    List<Discount> discounts = new LinkedList<>();

    @Override
    public Discount getDiscountById(int id) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Discount WHERE id=" + id);
            if (resultSet.next()) {
                System.out.println(getDiscountById(resultSet));
                return getDiscountById(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Discount getDiscountById(ResultSet resultSet) throws SQLException {
        Discount newDiscount = new Discount();
        newDiscount.setId(resultSet.getInt("id"));
        newDiscount.setDiscount_name(resultSet.getString("discount_name"));
        newDiscount.setDiscount_success(resultSet.getBoolean("discount_success"));
        return newDiscount;
    }


    @Override
    public List<Discount> getAllDiscounts() {
        PreparedStatement preparedStatement;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM Discount");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                discounts.add(getDiscountById(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return discounts;
    }

    @Override
    public void addDiscount(int id, String discount_name, boolean discount_success) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Discount VALUE(default, ?, ?)");
            preparedStatement.setString(1, discount_name);
            preparedStatement.setBoolean(2, discount_success);
            if (preparedStatement.executeUpdate() == 1) {
                System.out.println("Insertion is successful.");
            } else
                System.out.println("Insertion was failed.");
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    @Override
    public void updateDiscount(Discount discount) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Discount SET discount_name=?, " +
                    "discount_success=? WHERE id=?");
            preparedStatement.setString(1, discount.getDiscount_name());
            preparedStatement.setBoolean(2, true);
            preparedStatement.setInt(3, discount.getId());
            if (preparedStatement.executeUpdate() == 1) {
                System.out.println("Update process is successful: " + discount.getId() + "-" + discount.getDiscount_name());
            } else
                System.out.println("Update process was failed: " + discount.getId() + "-" + discount.getDiscount_name());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDiscount(int id) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Discount WHERE id=" + id);
            if (preparedStatement.executeUpdate() == 1) {
                System.out.println("Delete process is successful.");
            } else
                System.out.println("Delete process was failed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
