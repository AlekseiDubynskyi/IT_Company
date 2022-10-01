package com.solvd.it_company.patterns.abstractFactory;

import com.solvd.it_company.patterns.abstractFactory.teams.BestTeam;
import com.solvd.it_company.patterns.abstractFactory.teams.JavaLovers;
import com.solvd.it_company.patterns.abstractFactory.teams.TopCommunicators;

public class TeamFactory extends AbstractFactory {
    @Override
    Team setTeam(String team) {
        if (team == null) {
            return null;
        }
        if (team.equalsIgnoreCase("BestTeam")) {
            return new BestTeam();
        } else if (team.equalsIgnoreCase("JavaLovers")) {
            return new JavaLovers();
        } else if (team.equalsIgnoreCase("TopCommunicators")) {
            return new TopCommunicators();
        }
        return null;
    }

    @Override
    Position getPosition(String position) {
        return null;
    }
}
