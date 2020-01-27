package com.company.BattleShips;

class Coordinate {
    private final int x;
    private final int y;

    public Coordinate(int[] coordinates) {
        this.x = coordinates[0];
        this.y = coordinates[1];
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}