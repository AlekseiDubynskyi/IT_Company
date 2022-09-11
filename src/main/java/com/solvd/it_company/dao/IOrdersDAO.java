package com.solvd.it_company.dao;

import com.solvd.it_company.models.*;

import java.util.Date;
import java.util.List;

public interface IOrdersDAO {
    Orders getOrderById(int id);

    List<Orders> getAllOrders();

    void addOrder(int id, double price, Date date_creation, String payment_type, Date date_payment, int customer_id, int team_id, int discount_id, int service_category_id);

    void updateOrder(Orders orders);

    void deleteOrder(int id);
}
