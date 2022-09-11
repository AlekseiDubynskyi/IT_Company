package com.solvd.it_company.models;

public class Service_category {
    private int id;
    private int service_id;
    private int category_id;

    public Service_category() {
    }

    public Service_category(int id, int service_id, int category_id) {
        this.id = id;
        this.service_id = service_id;
        this.category_id = category_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return "Service_category{" +
                "id=" + id +
                ", service_id=" + service_id +
                ", category_id=" + category_id +
                '}';
    }
}
