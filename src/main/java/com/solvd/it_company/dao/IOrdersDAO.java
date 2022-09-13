package com.solvd.it_company.dao;

import com.solvd.it_company.models.*;

import java.util.Date;
import java.util.List;

public interface IOrdersDAO {
    Orders getOrderById(int id);

    List<Orders> getAllOrders();

    void addOrder(Orders orders);

    void updateOrder(Orders orders);

    void deleteOrder(int id);
}
