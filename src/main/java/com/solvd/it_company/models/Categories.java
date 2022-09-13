package com.solvd.it_company.models;

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
    public String toString() {
        return "Categories{" +
                "id=" + id +
                ", category name='" + categoryName + '\'' +
                '}';
    }
}
