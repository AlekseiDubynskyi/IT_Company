package com.solvd.it_company.dao;

import com.solvd.it_company.models.Categories;
import com.solvd.it_company.models.Service_category;
import com.solvd.it_company.models.Services;

import java.util.List;

public interface IService_categoryDAO {
    Service_category getService_categoryById(int id);

    List<Service_category> getAllService_categories();

    void addService_category(int id, int service_id, int category_id);

    void updateService_category(Service_category service_category);

    void deleteService_category(int id);
}
