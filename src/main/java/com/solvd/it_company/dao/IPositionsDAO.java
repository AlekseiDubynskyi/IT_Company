package com.solvd.it_company.dao;

import com.solvd.it_company.models.Positions;

import java.util.List;

public interface IPositionsDAO {
    Positions getPositionById(int id);

    List<Positions> getAllPositions();

    void addPosition(Positions positions);

    void updatePosition(Positions positions);

    void deletePosition(int id);
}
