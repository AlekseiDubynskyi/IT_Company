package com.solvd.it_company.models;

import java.util.Objects;

public class ServiceCategory {
    private int id;
    private int serviceId;
    private int categoryId;

    public ServiceCategory() {
    }

    public ServiceCategory(int serviceId, int categoryId) {
        this.serviceId = serviceId;
        this.categoryId = categoryId;
    }

    public ServiceCategory(int id, int serviceId, int categoryId) {
        this.id = id;
        this.serviceId = serviceId;
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceCategory that = (ServiceCategory) o;
        return id == that.id && serviceId == that.serviceId && categoryId == that.categoryId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, serviceId, categoryId);
    }

    @Override
    public String toString() {
        return "Service_category{" +
                "id=" + id +
                ", service id=" + serviceId +
                ", category id=" + categoryId +
                '}';
    }
}
