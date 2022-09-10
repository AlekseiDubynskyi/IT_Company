package com.solvd.it_company.dao;

import com.solvd.it_company.models.*;

import java.util.Date;
import java.util.List;

public interface IOrdersDAO {
    Orders getOrderById(int id);

    List<Orders> getAllOrders();

    void addOrder(int id, double price, Date date_creation, String payment_type, Date date_payment, Customers customers,
                  Teams teams, Discount discount, Service_category service_category);

    void updateOrder(Orders orders);

    void deleteOrder(int id);
}
