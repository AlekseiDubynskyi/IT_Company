package com.solvd.it_company.models;

import java.util.Objects;

public class Discount {
    private int id;
    private String discountName;
    private boolean discountSuccess;

    public Discount() {
    }

    public Discount(String discountName, boolean discountSuccess) {
        this.discountName = discountName;
        this.discountSuccess = discountSuccess;
    }

    public Discount(int id, String discountName, boolean discountSuccess) {
        this.id = id;
        this.discountName = discountName;
        this.discountSuccess = discountSuccess;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiscountName() {
        return discountName;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    public boolean getDiscountSuccess() {
        return discountSuccess;
    }

    public void setDiscountSuccess(boolean discountSuccess) {
        this.discountSuccess = discountSuccess;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discount discount = (Discount) o;
        return id == discount.id && discountSuccess == discount.discountSuccess && discountName.equals(discount.discountName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, discountName, discountSuccess);
    }

    @Override
    public String toString() {
        return "Discount{" +
                "id=" + id +
                ", discount name='" + discountName + '\'' +
                ", discount success=" + discountSuccess +
                '}';
    }
}
