package com.solvd.it_company.models;

public class Service_category {
    private int id;
    private Services services;
    private Categories categories;

    public Service_category() {
    }

    public Service_category(int id, Services services, Categories categories) {
        this.id = id;
        this.services = services;
        this.categories = categories;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Service_category{" +
                "id=" + id +
                ", services=" + services +
                ", categories=" + categories +
                '}';
    }
}
