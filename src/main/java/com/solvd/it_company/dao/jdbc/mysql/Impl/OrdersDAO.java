package com.solvd.it_company.dao.jdbc.mysql.Impl;

import com.solvd.it_company.connection.ConnectionUtil;
import com.solvd.it_company.dao.IOrdersDAO;
import com.solvd.it_company.models.Customer_types;
import com.solvd.it_company.models.Orders;

import java.sql.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class OrdersDAO implements IOrdersDAO {
    List<Orders> orders = new LinkedList<>();

    @Override
    public Orders getOrderById(int id) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Orders WHERE id=" + id);
            if (resultSet.next()) {
                System.out.println(getOrderById(resultSet));
                return getOrderById(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Orders getOrderById(ResultSet resultSet) throws SQLException {
        Orders newOrder = new Orders();
        newOrder.setId(resultSet.getInt("id"));
        newOrder.setPrice(resultSet.getDouble("price"));
        newOrder.setDate_creation(resultSet.getDate("date_creation"));
        newOrder.setPayment_type(resultSet.getString("payment_type"));
        newOrder.setDate_payment(resultSet.getDate("date_payment"));
        newOrder.setCustomer_id(resultSet.getInt("customer_id"));
        newOrder.setTeam_id(resultSet.getInt("team_id"));
        newOrder.setDiscount_id(resultSet.getInt("discount_id"));
        newOrder.setService_category_id(resultSet.getInt("service_category_id"));
        return newOrder;
    }

    @Override
    public List<Orders> getAllOrders() {
        PreparedStatement preparedStatement;
        Connection connection = ConnectionUtil.getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM Orders");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                orders.add(getOrderById(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public void addOrder(int id, double price, Date date_creation, String payment_type, Date date_payment, int customer_id, int team_id, int discount_id, int service_category_id) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Orders VALUE(default, ?, ?, ?, ?, ?, ?, ?, ?)");
            preparedStatement.setDouble(1, price);
            preparedStatement.setDate(2, (java.sql.Date) date_creation);
            preparedStatement.setString(3, payment_type);
            preparedStatement.setDate(4, (java.sql.Date) date_payment);
            preparedStatement.setInt(5, customer_id);
            preparedStatement.setInt(6, team_id);
            preparedStatement.setInt(7, discount_id);
            preparedStatement.setInt(8, service_category_id);
            if (preparedStatement.executeUpdate() == 1) {
                System.out.println("Insertion is successful.");
            } else
                System.out.println("Insertion was failed.");
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    @Override
    public void updateOrder(Orders orders) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Orders SET price=?, date_creation=?, payment_type=?, date_payment=?, customer_id=?, team_id=?, discount_id=?, service_category_id=? WHERE id=?");
            preparedStatement.setDouble(1, orders.getPrice());
            preparedStatement.setDate(2, (java.sql.Date) orders.getDate_creation());
            preparedStatement.setString(3,orders.getPayment_type());
            preparedStatement.setDate(4, (java.sql.Date) orders.getDate_payment());
            preparedStatement.setInt(5, orders.getCustomer_id());
            preparedStatement.setInt(6, orders.getTeam_id());
            preparedStatement.setInt(7, orders.getDiscount_id());
            preparedStatement.setInt(8, orders.getService_category_id());
            preparedStatement.setInt(9, orders.getId());
            if (preparedStatement.executeUpdate() == 1) {
                System.out.println("Update process is successful: " + orders.getId());
            } else
                System.out.println("Update process was failed: " + orders.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrder(int id) {
        Connection connection = ConnectionUtil.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Orders WHERE id=" + id);
            if (preparedStatement.executeUpdate() == 1) {
                System.out.println("Delete process is successful.");
            } else
                System.out.println("Delete process was failed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
