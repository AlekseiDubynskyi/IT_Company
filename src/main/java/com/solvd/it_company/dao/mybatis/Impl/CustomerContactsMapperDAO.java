package com.solvd.it_company.dao.mybatis.Impl;

import com.solvd.it_company.connection.MyBatisUtil;
import com.solvd.it_company.dao.ICustomerContactsDAO;
import com.solvd.it_company.models.CustomerContacts;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public class CustomerContactsMapperDAO implements ICustomerContactsDAO {
    private final static Logger LOGGER = LogManager.getLogger(CustomerContactsMapperDAO.class);

    @Override
    public CustomerContacts getCustomerContactById(int id) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        CustomerContacts customerContacts = session.selectOne("src.main.resources.myBatis.mappers.CustomerContactsMapper.getCustomerContactById", id);
        session.close();
        return customerContacts;
    }

    @Override
    public List<CustomerContacts> getAllCustomerContacts() {
        List<CustomerContacts> customerContacts = new LinkedList<>();
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        customerContacts = session.selectList("src.main.resources.myBatis.mappers.CustomerContactsMapper.getAllCustomerContacts", customerContacts);
        session.close();
        customerContacts.forEach(LOGGER::info);
        return customerContacts;
    }

    @Override
    public void addCustomerContact(CustomerContacts customerContacts) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        session.insert("src.main.resources.myBatis.mappers.CustomerContactsMapper.addCustomerContact", customerContacts);
        session.commit();
        session.close();
    }

    @Override
    public void updateCustomerContact(CustomerContacts customerContacts) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        session.update("src.main.resources.myBatis.mappers.CustomerContactsMapper.updateCustomerContact", customerContacts);
        session.commit();
        session.close();
    }

    @Override
    public void deleteCustomerContact(int id) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        session.delete("src.main.resources.myBatis.mappers.CustomerContactsMapper.deleteCustomerContact", id);
        session.commit();
        session.close();
    }
}
