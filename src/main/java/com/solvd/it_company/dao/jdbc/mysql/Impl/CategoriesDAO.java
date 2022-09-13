package com.solvd.it_company.dao.jdbc.mysql.Impl;

import com.solvd.it_company.connection.ConnectionUtil;
import com.solvd.it_company.dao.ICategoriesDAO;
import com.solvd.it_company.models.Categories;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class CategoriesDAO implements ICategoriesDAO {
    private static final Logger LOGGER = LogManager.getLogger(CategoriesDAO.class);

    @Override
    public Categories getCategoryById(int id) {
        ResultSet resultSet = null;
        Statement statement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Categories WHERE id=" + id);
            if (resultSet.next()) {
                LOGGER.info(getCategoryById(resultSet));
                return getCategoryById(resultSet);
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

    private Categories getCategoryById(ResultSet resultSet) throws SQLException {
        Categories newCategory = new Categories();
        newCategory.setId(resultSet.getInt("id"));
        newCategory.setCategoryName(resultSet.getString("category_name"));
        return newCategory;
    }

    @Override
    public List<Categories> getAllCategories() {
        List<Categories> categories = new LinkedList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM Categories");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                categories.add(getCategoryById(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(resultSet);
            ConnectionUtil.close(preparedStatement);
            ConnectionUtil.close(connection);
        }
        return categories;
    }

    @Override
    public void addCategory(Categories categories) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO Categories VALUE(default, ?)");
            preparedStatement.setString(1, categories.getCategoryName());
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
    public void updateCategory(Categories categories) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("UPDATE Categories SET category_name = ? WHERE id = ?");
            preparedStatement.setString(1, categories.getCategoryName());
            preparedStatement.setInt(2, categories.getId());
            if (preparedStatement.executeUpdate() == 1) {
                LOGGER.info("Update process is successful: " + categories.getId() + " - " + categories.getCategoryName());
            } else
                LOGGER.info("Update process was failed: " + categories.getId() + " - " + categories.getCategoryName());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(preparedStatement);
            ConnectionUtil.close(connection);
        }
    }

    @Override
    public void deleteCategory(int id) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM Categories WHERE id = " + id);
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
