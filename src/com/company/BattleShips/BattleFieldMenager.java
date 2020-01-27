package com.company.BattleShips;

import java.util.concurrent.atomic.AtomicInteger;

class BattleFieldManager {
    private final char [][] battleField;
    private AtomicInteger ownShipsAlive;

    public BattleFieldManager(){
        this.ownShipsAlive = new AtomicInteger(0);
        this.battleField = new char[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                battleField[i][j] = ' ';
            }
        }
    }

    public AtomicInteger getNumberOfShips() {
        return this.ownShipsAlive;
    }

    public boolean anyShipsLeft() {
        return ownShipsAlive.get() > 0;
    }

    public void deployShip(Coordinate c) {
        this.battleField[c.getX()][c.getY()] = '@';
        this.ownShipsAlive.getAndIncrement();
    }

    public void destroyShip(Coordinate c) {
        this.battleField[c.getX()][c.getY()] = 'x';
    }

    public void destroyOwnShip(Coordinate c) {
        this.battleField[c.getX()][c.getY()] = '!';
        this.ownShipsAlive.getAndDecrement();
    }

    public void markMiss(Coordinate c) {
        this.battleField[c.getX()][c.getY()] = '-';
    }

    public char getValue(Coordinate c) {
        return this.battleField[c.getX()][c.getY()];
    }

    public boolean isThisShip(Coordinate c) {
        return this.battleField[c.getX()][c.getY()] == '@';
    }
}

