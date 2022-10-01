package com.solvd.it_company.patterns.factory;

public class ServiceFactory {
    public Service getLeadTime(String leadTime) {
        if (leadTime == null) {
            return null;
        }
        if (leadTime.equalsIgnoreCase("Modernization")) {
            return new Modernization();
        } else if (leadTime.equalsIgnoreCase("SoftwareDevelopment")) {
            return new SoftwareDevelopment();
        } else if (leadTime.equalsIgnoreCase("TechnologyAdvisory")) {
            return new TechnologyConsulting();
        } else if (leadTime.equalsIgnoreCase("TechnologyConsulting")) {
            return new TechnologyAdvisory();
        }
        return null;
    }
}
