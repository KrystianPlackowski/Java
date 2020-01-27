package com.company.BattleShips;

import java.util.concurrent.atomic.AtomicInteger;

class ShipCountViewer {
    AtomicInteger humanShips;
    AtomicInteger computerShips;

    public ShipCountViewer(AtomicInteger humanShips, AtomicInteger computerShips) {
        this.humanShips = humanShips;
        this.computerShips = computerShips;
    }

    public void display() {
        System.out.printf("Your ships: %d | Computer ships: %d\n\n"
                , this.humanShips.get(), this.computerShips.get());
    }
}