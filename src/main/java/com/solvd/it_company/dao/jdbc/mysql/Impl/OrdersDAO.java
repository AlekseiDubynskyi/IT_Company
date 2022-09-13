package com.solvd.it_company.dao.jdbc.mysql.Impl;

import com.solvd.it_company.connection.ConnectionUtil;
import com.solvd.it_company.dao.IOrdersDAO;
import com.solvd.it_company.models.Orders;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class OrdersDAO implements IOrdersDAO {
    private static final Logger LOGGER = LogManager.getLogger(OrdersDAO.class);

    @Override
    public Orders getOrderById(int id) {
        ResultSet resultSet = null;
        Statement statement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Orders WHERE id=" + id);
            if (resultSet.next()) {
                LOGGER.info(getOrderById(resultSet));
                return getOrderById(resultSet);
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

    private Orders getOrderById(ResultSet resultSet) throws SQLException {
        Orders newOrder = new Orders();
        newOrder.setId(resultSet.getInt("id"));
        newOrder.setPrice(resultSet.getDouble("price"));
        newOrder.setDateCreation(resultSet.getDate("date_creation"));
        newOrder.setPaymentType(resultSet.getString("payment_type"));
        newOrder.setDatePayment(resultSet.getDate("date_payment"));
        newOrder.setCustomerId(resultSet.getInt("customer_id"));
        newOrder.setTeamId(resultSet.getInt("team_id"));
        newOrder.setDiscountId(resultSet.getInt("discount_id"));
        newOrder.setServiceCategoryId(resultSet.getInt("service_category_id"));
        return newOrder;
    }

    @Override
    public List<Orders> getAllOrders() {
        List<Orders> orders = new LinkedList<>();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM Orders");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                orders.add(getOrderById(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(resultSet);
            ConnectionUtil.close(preparedStatement);
            ConnectionUtil.close(connection);
        }
        return orders;
    }

    @Override
    public void addOrder(Orders orders) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO Orders VALUE(default, ?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setDouble(1, orders.getPrice());
            preparedStatement.setDate(2, (java.sql.Date) orders.getDateCreation());
            preparedStatement.setString(3, orders.getPaymentType());
            preparedStatement.setDate(4, (java.sql.Date) orders.getDatePayment());
            preparedStatement.setInt(5, orders.getCustomerId());
            preparedStatement.setInt(6, orders.getTeamId());
            preparedStatement.setInt(7, orders.getDiscountId());
            preparedStatement.setInt(8, orders.getServiceCategoryId());
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
    public void updateOrder(Orders orders) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("UPDATE Orders SET price=?, date_creation=?, payment_type=?, date_payment=?, customer_id=?, team_id=?, discount_id=?, service_category_id=? WHERE id=?");
            preparedStatement.setDouble(1, orders.getPrice());
            preparedStatement.setDate(2, (java.sql.Date) orders.getDateCreation());
            preparedStatement.setString(3, orders.getPaymentType());
            preparedStatement.setDate(4, (java.sql.Date) orders.getDatePayment());
            preparedStatement.setInt(5, orders.getCustomerId());
            preparedStatement.setInt(6, orders.getTeamId());
            preparedStatement.setInt(7, orders.getDiscountId());
            preparedStatement.setInt(8, orders.getServiceCategoryId());
            preparedStatement.setInt(9, orders.getId());
            if (preparedStatement.executeUpdate() == 1) {
                LOGGER.info("Update process is successful: " + orders.getId());
            } else
                LOGGER.info("Update process was failed: " + orders.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionUtil.close(preparedStatement);
            ConnectionUtil.close(connection);
        }
    }

    @Override
    public void deleteOrder(int id) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM Orders WHERE id=" + id);
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
