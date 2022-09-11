package com.solvd.it_company.dao.jdbc.mysql.Impl;

import com.solvd.it_company.connection.ConnectionUtil;
import com.solvd.it_company.dao.ICategoriesDAO;
import com.solvd.it_company.models.Categories;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class CategoriesDAO implements ICategoriesDAO {
    List<Categories> categories = new LinkedList<>();

    @Override
    public Categories getCategoryById(int id) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Categories WHERE id=" + id);
            if (resultSet.next()) {
                System.out.println(getCategoryById(resultSet));
                return getCategoryById(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Categories getCategoryById(ResultSet resultSet) throws SQLException {
        Categories newCategory = new Categories();
        newCategory.setId(resultSet.getInt("id"));
        newCategory.setCategory_name(resultSet.getString("category_name"));
        return newCategory;
    }

    @Override
    public List<Categories> getAllCategories() {
        PreparedStatement preparedStatement;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM Categories");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                categories.add(getCategoryById(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public void addCategory(int id, String category_name) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Categories VALUE(default, ?)");
            preparedStatement.setString(1, category_name);
            if (preparedStatement.executeUpdate() == 1) {
                System.out.println("Insertion is successful.");
            } else
                System.out.println("Insertion was failed.");
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    @Override
    public void updateCategory(Categories categories) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Categories SET category_name=? WHERE id=?");
            preparedStatement.setString(1, categories.getCategory_name());
            preparedStatement.setInt(2, categories.getId());
            if (preparedStatement.executeUpdate() == 1) {
                System.out.println("Update process is successful: " + categories.getId() + "-" + categories.getCategory_name());
            } else
                System.out.println("Update process was failed: " + categories.getId() + "-" + categories.getCategory_name());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCategory(int id) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Categories WHERE id=" + id);
            if (preparedStatement.executeUpdate() == 1) {
                System.out.println("Delete process is successful.");
            } else
                System.out.println("Delete process was failed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
