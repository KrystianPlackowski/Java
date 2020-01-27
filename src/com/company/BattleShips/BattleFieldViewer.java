package com.company.BattleShips;

class BattleFieldViewer {
    BattleFieldManager battleFieldManager;

    public BattleFieldViewer(BattleFieldManager battleFieldManager) {
        this.battleFieldManager = battleFieldManager;
    }

    public void displayField() {
        System.out.println();
        displayHeader();
        displayBody();
        displayHeader();
        System.out.println();
    }

    private void displayHeader() {
        System.out.print("  ");
        for (int i = 0; i < 10; i++) {
            System.out.print(i);
        }
        System.out.print('\n');
    }

    private void displayBody() {
        for (int i = 0; i < 10; i++) {
            System.out.print(i);
            System.out.print('|');
            for (int j = 0; j < 10; j++) {
                System.out.print(this.battleFieldManager.getValue(new Coordinate(new int[]{i, j})));
            }
            System.out.print('|');
            System.out.print(i);
            System.out.println();
        }
    }
}