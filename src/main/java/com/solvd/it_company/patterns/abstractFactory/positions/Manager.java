package com.solvd.it_company.patterns.abstractFactory.positions;

import com.solvd.it_company.patterns.abstractFactory.Position;

public class Manager implements Position {
    @Override
    public void drawPosition() {
        System.out.println("Manager position");
    }
}
