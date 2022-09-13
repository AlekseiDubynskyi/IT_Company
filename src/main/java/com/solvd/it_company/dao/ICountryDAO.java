package com.solvd.it_company.dao;

import com.solvd.it_company.models.Country;

import java.util.List;

public interface ICountryDAO {
    Country getCountryById(int id);

    List<Country> getAllCountries();

    void addCountry(Country country);

    void updateCountry(Country country);

    void deleteCountry(int id);
}
