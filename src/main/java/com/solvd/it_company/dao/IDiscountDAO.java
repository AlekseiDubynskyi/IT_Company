package com.solvd.it_company.dao;

import com.solvd.it_company.models.*;

import java.util.List;

public interface IDiscountDAO {
    Discount getDiscountById(int id);

    List<Discount> getAllDiscounts();

    void addDiscount(Discount discount);

    void updateDiscount(Discount discount);

    void deleteDiscount(int id);
}