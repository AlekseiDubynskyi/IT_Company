package com.solvd.it_company.patterns.factory;

public class TechnologyAdvisory implements Service {
    @Override
    public void leadTime() {
        System.out.println("Lead time for Technology Advisory service is from 1 to 2 weeks");
    }
}
