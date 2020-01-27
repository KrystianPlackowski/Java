package com.company.BattleShips;

public class Main {
    public static void main(String[] args) {

        Player human = new HumanPlayer();
        Player computer = new ComputerPlayer();
        BattleFieldManager humanManager = new BattleFieldManager();
        BattleFieldManager computerManager = new BattleFieldManager();

        System.out.print("**** Welcome to Battle Ships game ****\n\n");
        System.out.print("Right now, the sea is empty\n");
        new BattleFieldViewer(humanManager).displayField();

        for (int i = 0; i < 10; i++) {
            CompoundCoordinateValidator humanCoordinateValidator = new CompoundCoordinateValidator(
                    new CoordinateRangeValidator(0, 10, 0, 10),
                    new BattleFieldLocationCoordinateValidator(humanManager));

            Coordinate coordinates = computer.pickCoordinates();
            while (!humanCoordinateValidator.isValid(coordinates)) {
                //System.out.print("Error! Coordinates have to be in range(0, 10), ");
                //System.out.print("type Integer and cannot repeat\n");
                coordinates = computer.pickCoordinates();
            }
            humanManager.deployShip(coordinates);
            System.out.printf("%d. ship DEPLOYED for you\n", i + 1);
        }

        new BattleFieldViewer(humanManager).displayField();

        for (int i = 0; i < 10; i++) {
            CompoundCoordinateValidator computerCoordinateValidator = new CompoundCoordinateValidator(
                    new CoordinateRangeValidator(0, 10, 0, 10),
                    new BattleFieldLocationCoordinateValidator(computerManager),
                    new BattleFieldLocationCoordinateValidator(humanManager));

            Coordinate coordinates = computer.pickCoordinates();
            while (!computerCoordinateValidator.isValid(coordinates)) {
                coordinates = computer.pickCoordinates();
            }
            computerManager.deployShip(coordinates);
            System.out.printf("%d. ship DEPLOYED by computer\n", i + 1);
        }
        System.out.println();

        CoordinateRangeValidator humanCoordinateValidator =
                new CoordinateRangeValidator(0, 10, 0, 10);
        CompoundCoordinateValidator computerCoordinateValidator = new CompoundCoordinateValidator(
                new CoordinateRangeValidator(0, 10, 0, 10),
                new BattleFieldLocationCoordinateValidator(computerManager));

        while (humanManager.anyShipsLeft() && computerManager.anyShipsLeft()) {
            System.out.print("YOUR TURN\n");
            Coordinate coordinates = human.pickCoordinates();
            while (!humanCoordinateValidator.isValid(coordinates)) {
                System.out.print("Error! Coordinates have to be in range(0, 10) ");
                System.out.print("and type Integer\n");
                coordinates = human.pickCoordinates();
            }

            if (computerManager.isThisShip(coordinates)) {
                System.out.print("Boom! You sunk the ship!\n");
                humanManager.destroyShip(coordinates);
                computerManager.destroyOwnShip(coordinates);
            } else if (humanManager.isThisShip(coordinates)) {
                System.out.print("Oh no, you sunk your own ship :(\n");
                humanManager.destroyOwnShip(coordinates);
                computerManager.destroyShip(coordinates);
            } else {
                System.out.print("Sorry, you missed\n");
                humanManager.markMiss(coordinates);
            }

            System.out.print("COMPUTER\'S TURN\n");
            coordinates = computer.pickCoordinates();
            while (!computerCoordinateValidator.isValid(coordinates)) {
                coordinates = computer.pickCoordinates();
            }

            if (humanManager.isThisShip(coordinates)) {
                System.out.print("The computer sunk one of your ships!\n");
                humanManager.destroyOwnShip(coordinates);
                computerManager.destroyShip(coordinates);
            } else if (computerManager.isThisShip(coordinates)) {
                System.out.print("The computer sunk one of its own ships\n");
                humanManager.destroyShip(coordinates);
                computerManager.destroyOwnShip(coordinates);
            } else {
                System.out.print("Computer missed\n");
                computerManager.markMiss(coordinates);
            }

            new BattleFieldViewer(humanManager).displayField();
            new ShipCountViewer(
                    humanManager.getNumberOfShips(),
                    computerManager.getNumberOfShips()).display();
        }

        if (humanManager.anyShipsLeft()) {
            System.out.println("Hooray! You win the battle :)");
        }
        else {
            System.out.println("Sorry! You lose the game!");
        }
    }
}
