package com.solvd.it_company.dao.mybatis.Impl;

import com.solvd.it_company.connection.MyBatisUtil;
import com.solvd.it_company.models.CustomerContacts;
import com.solvd.it_company.models.Orders;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public class OrdersMapperDAO {
    private static final Logger LOGGER = LogManager.getLogger(OrdersMapperDAO.class);

    public List<Orders> getAllOrders() {
        List<Orders> orders = new LinkedList<>();
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        orders = session.selectList("src.main.resources.mappers.OrdersMapper.getAllOrders", orders);
        session.close();
        orders.forEach(LOGGER::info);
        return orders;
    }
}
