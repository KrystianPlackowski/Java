package com.company.BattleShips;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

interface Player {
    Coordinate pickCoordinates();
}

class HumanPlayer implements Player {
    private final Scanner input;

    public HumanPlayer() {
        input = new Scanner(System.in);
    }

    @Override
    public Coordinate pickCoordinates() {
        int x;
        int y;
        System.out.print("Enter X coordinate for fire: ");
        try {
            x = input.nextInt();
        } catch (InputMismatchException e) {
            x = 10;
        }
        System.out.print("Enter Y coordinate for fire: ");
        try {
            y = input.nextInt();
        } catch (InputMismatchException e) {
            y = 10;
        }
        //System.out.printf("You entered: X = %d, Y = %d\n", x, y);
        return new Coordinate(new int []{x, y});
    }
}

class ComputerPlayer implements Player {
    private final Random random;

    public ComputerPlayer() {
        random = new Random();
    }

    @Override
    public Coordinate pickCoordinates() {
        return new Coordinate(new int []{random.nextInt(10), random.nextInt(10)});
    }
}
