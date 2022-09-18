package com.solvd.it_company.models;

import java.util.Objects;

public class Services {
    private int id;
    private String serviceName;
    private String leadTime;

    public Services() {
    }

    public Services(String serviceName, String leadTime) {
        this.serviceName = serviceName;
        this.leadTime = leadTime;
    }

    public Services(int id, String serviceName, String leadTime) {
        this.id = id;
        this.serviceName = serviceName;
        this.leadTime = leadTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getLeadTime() {
        return leadTime;
    }

    public void setLeadTime(String leadTime) {
        this.leadTime = leadTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Services services = (Services) o;
        return id == services.id && serviceName.equals(services.serviceName) && leadTime.equals(services.leadTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, serviceName, leadTime);
    }

    @Override
    public String toString() {
        return "Services{" +
                "id=" + id +
                ", service_name='" + serviceName + '\'' +
                ", lead_time='" + leadTime + '\'' +
                '}';
    }
}
