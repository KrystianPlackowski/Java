package com.company.BattleShips;

import java.util.Arrays;

interface CoordinateValidator {
    boolean isValid(Coordinate coordinate);
}

class CoordinateRangeValidator implements CoordinateValidator {
    private final int minX;
    private final int maxX;
    private final int minY;
    private final int maxY;

    CoordinateRangeValidator(int minX, int maxX, int minY, int maxY) {
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
    }

    @Override
    public boolean isValid(Coordinate coordinate) {
        int x = coordinate.getX();
        int y = coordinate.getY();
        return minX <= x && x < maxX && minY <= y && y < maxY;
    }
}

class BattleFieldLocationCoordinateValidator implements CoordinateValidator {
    private final BattleFieldManager menager;

    public BattleFieldLocationCoordinateValidator(BattleFieldManager manager) {
        this.menager = manager;
    }

    @Override
    public boolean isValid(Coordinate coordinate) {
        return menager.getValue(coordinate) == ' ';
    }
}

class CompoundCoordinateValidator implements CoordinateValidator {
    private final CoordinateValidator[] coordinateValidators;

    CompoundCoordinateValidator(CoordinateValidator... coordinateValidators) {
        this.coordinateValidators = coordinateValidators;
    }

    @Override
    public boolean isValid(Coordinate coordinate) {
        return Arrays.stream(coordinateValidators).allMatch(cv -> cv.isValid(coordinate));
    }
}