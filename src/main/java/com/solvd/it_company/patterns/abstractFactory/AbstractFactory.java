package com.solvd.it_company.patterns.abstractFactory;

public abstract class AbstractFactory {
    abstract Position getPosition(String position);
    abstract Team setTeam(String team);
}
