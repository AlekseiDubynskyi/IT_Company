package com.solvd.it_company.patterns.abstractFactory.teams;

import com.solvd.it_company.patterns.abstractFactory.Team;

public class JavaLovers implements Team {
    @Override
    public void fillTeam() {
        System.out.println("Java Lovers team is here!");
    }
}
