package com.solvd.it_company.patterns.factory;

public class TechnologyConsulting implements Service {
    @Override
    public void leadTime() {
        System.out.println("Lead time for Technology Consulting service is from 1 to 3 weeks");
    }
}
