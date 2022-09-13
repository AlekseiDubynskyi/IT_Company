package com.solvd.it_company.dao;

import com.solvd.it_company.models.Services;

import java.util.List;

public interface IServicesDAO {
    Services getServiceById(int id);

    List<Services> getAllServices();

    void addService(Services services);

    void updateService(Services services);

    void deleteService(int id);
}
