package com.solvd.it_company.patterns.factory;

public class SoftwareDevelopment implements Service {
    @Override
    public void leadTime() {
        System.out.println("Lead time for Software Development service is from 2 to 6 months");
    }
}
