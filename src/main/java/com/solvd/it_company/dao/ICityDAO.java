package com.solvd.it_company.dao;

import com.solvd.it_company.models.City;

import java.util.List;

public interface ICityDAO {
    City getCityById(int id);

    List<City> getAllCities();

    void addCity(int id, String city, int country_id);

    void updateCity(City city);

    void deleteCity(int id);
}
