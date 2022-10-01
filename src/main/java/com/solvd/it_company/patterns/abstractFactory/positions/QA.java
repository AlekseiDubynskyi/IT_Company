package com.solvd.it_company.patterns.abstractFactory.positions;

import com.solvd.it_company.patterns.abstractFactory.Position;

public class QA implements Position {
    @Override
    public void drawPosition() {
        System.out.println("QA position");
    }
}
