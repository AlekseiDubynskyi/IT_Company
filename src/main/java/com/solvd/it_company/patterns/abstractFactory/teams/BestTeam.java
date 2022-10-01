package com.solvd.it_company.patterns.abstractFactory.teams;

import com.solvd.it_company.patterns.abstractFactory.Team;

public class BestTeam implements Team {
    @Override
    public void fillTeam() {
        System.out.println("Best Team is here!");
    }
}
