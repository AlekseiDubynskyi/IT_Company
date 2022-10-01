package com.solvd.it_company.patterns.abstractFactory;

import com.solvd.it_company.patterns.abstractFactory.positions.Developer;
import com.solvd.it_company.patterns.abstractFactory.positions.Manager;
import com.solvd.it_company.patterns.abstractFactory.positions.QA;

public class PositionFactory extends AbstractFactory {
    @Override
    Position getPosition(String position) {
        if (position == null) {
            return null;
        }
        if (position.equalsIgnoreCase("Developer")) {
            return new Developer();
        } else if (position.equalsIgnoreCase("Manager")) {
            return new Manager();
        } else if (position.equalsIgnoreCase("QA")) {
            return new QA();
        }
        return null;
    }

    @Override
    Team setTeam(String team) {
        return null;
    }
}
