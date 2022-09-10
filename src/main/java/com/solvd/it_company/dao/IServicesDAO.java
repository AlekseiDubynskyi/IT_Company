package com.solvd.it_company.dao;

import com.solvd.it_company.models.Services;

import java.util.List;

public interface IServicesDAO {
    Services getServiceById(int id);

    List<Services> getAllServices();

    void addService(int id, String service_name, String lead_time);

    void updateService(Services services);

    void deleteService(int id);
}
