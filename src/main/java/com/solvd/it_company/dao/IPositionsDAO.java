package com.solvd.it_company.dao;

import com.solvd.it_company.models.Positions;

import java.util.List;

public interface IPositionsDAO {
    Positions getPositionById(int id);

    List<Positions> getAllPositions();

    void addPosition(int id, String position);

    void updatePosition(Positions positions);

    void deletePosition(int id);
}
