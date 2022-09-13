package com.solvd.it_company.dao;

import com.solvd.it_company.models.ServiceCategory;

import java.util.List;

public interface IServiceCategoryDAO {
    ServiceCategory getServiceCategoryById(int id);

    List<ServiceCategory> getAllServiceCategories();

    void addServiceCategory(ServiceCategory serviceCategory);

    void updateServiceCategory(ServiceCategory serviceCategory);

    void deleteServiceCategory(int id);
}
