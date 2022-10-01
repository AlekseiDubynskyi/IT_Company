package com.solvd.it_company.patterns.abstractFactory;

public class AbstractFactoryPatternTest {
    public static void main(String[] args){
        AbstractFactory positionFactory = FactoryGenerator.getFactory("Position");

        Position developer = positionFactory.getPosition("Developer");
        developer.drawPosition();

        Position manager = positionFactory.getPosition("Manager");
        manager.drawPosition();

        Position qa = positionFactory.getPosition("QA");
        qa.drawPosition();


        AbstractFactory teamFactory = FactoryGenerator.getFactory("Team");

        Team bestTeam = teamFactory.setTeam("BestTeam");
        bestTeam.fillTeam();

        Team javaLovers = teamFactory.setTeam("JavaLovers");
        javaLovers.fillTeam();

        Team topCommunicators = teamFactory.setTeam("TopCommunicators");
        topCommunicators.fillTeam();
    }
}
