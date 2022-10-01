package com.solvd.it_company.dao.mybatis.Impl;

import com.solvd.it_company.connection.MyBatisUtil;
import com.solvd.it_company.dao.ICityDAO;
import com.solvd.it_company.models.City;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.LinkedList;
import java.util.List;

public class CityMapperDAO implements ICityDAO {
    private final static Logger LOGGER = LogManager.getLogger(CityMapperDAO.class);

    @Override
    public City getCityById(int id) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        City city = session.selectOne("src.main.resources.myBatis.mappers.CityMapper.getCityById", id);
        session.close();
        return city;
    }

    @Override
    public List<City> getAllCities() {
        List<City> cities = new LinkedList<>();
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        cities = session.selectList("src.main.resources.myBatis.mappers.CityMapper.getAllCities", cities);
        session.close();
        cities.forEach(LOGGER::info);
        return cities;
    }

    @Override
    public void addCity(City city) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        session.insert("src.main.resources.myBatis.mappers.CityMapper.addCity", city);
        session.commit();
        session.close();
    }

    @Override
    public void updateCity(City city) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        session.update("src.main.resources.myBatis.mappers.CityMapper.updateCity", city);
        session.commit();
        session.close();
    }

    @Override
    public void deleteCity(int id) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        session.delete("src.main.resources.myBatis.mappers.CityMapper.deleteCity", id);
        session.commit();
        session.close();
    }
}
