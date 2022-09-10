package com.solvd.it_company.dao;

import com.solvd.it_company.models.*;

import java.util.List;

public interface IDiscountDAO {
    Discount getDiscountById(int id);

    List<Discount> getAllDiscounts();

    void addDiscount(int id, String discount_name, boolean discount_success);

    void updateDiscount(Discount discount);

    void deleteDiscount(int id);
}