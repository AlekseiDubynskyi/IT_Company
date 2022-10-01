package com.solvd.it_company.patterns.abstractFactory;

public class FactoryGenerator {
    public static AbstractFactory getFactory(String choice) {
        if (choice.equalsIgnoreCase("Position")) {
            return new PositionFactory();

        } else if (choice.equalsIgnoreCase("Team")) {
            return new TeamFactory();
        }

        return null;
    }
}
