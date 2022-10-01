package com.solvd.it_company.dao.mybatis.Impl;

import com.solvd.it_company.connection.MyBatisUtil;
import com.solvd.it_company.dao.ICountryDAO;
import com.solvd.it_company.models.Country;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public class CountryMapperDAO implements ICountryDAO {
    private final static Logger LOGGER = LogManager.getLogger(CountryMapperDAO.class);

    @Override
    public Country getCountryById(int id) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        Country country = session.selectOne("src.main.resources.myBatis.mappers.CountryMapper.getCountryById", id);
        session.close();
        return country;
    }

    @Override
    public List<Country> getAllCountries() {
        List<Country> countries = new LinkedList<>();
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        countries = session.selectList("src.main.resources.myBatis.mappers.CountryMapper.getAllCountries", countries);
        session.close();
        countries.forEach(LOGGER::info);
        return countries;
    }

    @Override
    public void addCountry(Country country) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        session.insert("src.main.resources.myBatis.mappers.CountryMapper.addCountry", country);
        session.commit();
        session.close();
    }

    @Override
    public void updateCountry(Country country) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        session.update("src.main.resources.myBatis.mappers.CountryMapper.updateCountry", country);
        session.commit();
        session.close();
    }

    @Override
    public void deleteCountry(int id) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        session.delete("src.main.resources.myBatis.mappers.CountryMapper.deleteCountry", id);
        session.commit();
        session.close();
    }
}
