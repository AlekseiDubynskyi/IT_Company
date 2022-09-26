package com.solvd.it_company.dao.mybatis.Impl;

import com.solvd.it_company.connection.MyBatisUtil;
import com.solvd.it_company.dao.IAddressesDAO;
import com.solvd.it_company.models.Addresses;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public class AddressesMapperDAO implements IAddressesDAO {
    private static final Logger LOGGER = LogManager.getLogger(AddressesMapperDAO.class);

    @Override
    public Addresses getAddressById(int id) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        Addresses addresses = session.selectOne("src.main.resources.mappers.AddressesMapper.getAddressById", id);
        session.close();
        return addresses;
    }

    @Override
    public List<Addresses> getAllAddresses() {
        List<Addresses> addresses = new LinkedList<>();
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        addresses = session.selectList("src.main.resources.mappers.AddressesMapper.getAllAddresses", addresses);
        session.close();
        addresses.forEach(LOGGER::info);
        return addresses;
    }

    @Override
    public void addAddress(Addresses addresses) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        session.insert("src.main.resources.mappers.AddressesMapper.addAddress", addresses);
        session.commit();
        session.close();
    }

    @Override
    public void updateAddress(Addresses addresses) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        session.update("src.main.resources.mappers.AddressesMapper.updateAddress", addresses);
        session.commit();
        session.close();
    }

    @Override
    public void deleteAddress(int id) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        session.delete("src.main.resources.mappers.AddressesMapper.deleteAddress", id);
        session.commit();
        session.close();
    }
}
