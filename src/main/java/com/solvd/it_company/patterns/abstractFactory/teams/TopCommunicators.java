package com.solvd.it_company.patterns.abstractFactory.teams;

import com.solvd.it_company.patterns.abstractFactory.Team;

public class TopCommunicators implements Team {
    @Override
    public void fillTeam() {
        System.out.println("Top Communicators team is here!");
    }
}
