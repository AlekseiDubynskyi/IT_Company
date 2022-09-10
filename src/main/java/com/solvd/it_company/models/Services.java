package com.solvd.it_company.models;

public class Services {
    private int id;
    private String service_name;
    private String lead_time;

    public Services() {
    }

    public Services(int id, String service_name, String lead_time) {
        this.id = id;
        this.service_name = service_name;
        this.lead_time = lead_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public String getLead_time() {
        return lead_time;
    }

    public void setLead_time(String lead_time) {
        this.lead_time = lead_time;
    }

    @Override
    public String toString() {
        return "Services{" +
                "id=" + id +
                ", service_name='" + service_name + '\'' +
                ", lead_time='" + lead_time + '\'' +
                '}';
    }
}
