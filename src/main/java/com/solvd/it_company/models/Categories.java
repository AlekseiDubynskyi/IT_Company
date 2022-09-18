package com.solvd.it_company.models;

import java.util.Objects;

public class Categories {
    private int id;
    private String categoryName;

    public Categories() {
    }

    public Categories(String categoryName) {
        this.categoryName = categoryName;
    }

    public Categories(int id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categories that = (Categories) o;
        return id == that.id && categoryName.equals(that.categoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categoryName);
    }

    @Override
    public String toString() {
        return "Categories{" +
                "id=" + id +
                ", category name='" + categoryName + '\'' +
                '}';
    }


}
