package com.solvd.it_company.dao;

import com.solvd.it_company.models.Categories;

import java.util.List;

public interface ICategoriesDAO {
    Categories getCategoryById(int id);

    List<Categories> getAllCategories();

    void addCategory(int id, String category_name);

    void updateCategory(Categories categories);

    void deleteCategory(int id);
}
