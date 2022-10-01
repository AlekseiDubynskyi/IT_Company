package com.solvd.it_company.patterns.factory;

public class Factory {
    public static void main(String[] args) {
        ServiceFactory serviceFactory = new ServiceFactory();

        Service modernization = serviceFactory.getLeadTime("Modernization");
        modernization.leadTime();

        Service softwareDevelopment = serviceFactory.getLeadTime("SoftwareDevelopment");
        softwareDevelopment.leadTime();

        Service technologyAdvisory = serviceFactory.getLeadTime("TechnologyAdvisory");
        technologyAdvisory.leadTime();

        Service technologyConsulting = serviceFactory.getLeadTime("TechnologyConsulting");
        technologyConsulting.leadTime();
    }
}
