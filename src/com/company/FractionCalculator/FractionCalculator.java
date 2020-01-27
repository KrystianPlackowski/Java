package com.company.FractionCalculator;

import java.util.Scanner;
import java.util.function.BiFunction;

public class FractionCalculator {

    public FractionCalculator() {
    }

    public BiFunction<Fraction, Fraction, ?> getFunction(String operator) {
        switch (operator) {
            case "+":
                return Fraction::add;
            case "-":
                return Fraction::substract;
            case "*":
                return Fraction::multiply;
            case "/":
                return Fraction::divide;
            case "=":
                return Fraction::equals;
        }
        throw new IllegalArgumentException();
    }

    public Object evaluate(Expression expression) {
        BiFunction func = getFunction(expression.getOperation());
        return func.apply(expression.getFirstFrac(), expression.getSecondFrac());
    }

    public boolean validFraction(String input) {
        return input.trim().matches("[-]?\\s*(0|[1-9][0-9]*)\\s*/\\s*([1-9][0-9]*)") ||
                input.trim().matches("[-]?\\s*(0|[1-9][0-9]*)");
    }

    public String getOperation(Scanner input) {
        System.out.println("Please enter an operation (+, -, /, *, = or Q to quit");
        String operator = input.nextLine().trim().toLowerCase();
        while (!operator.matches("[+\\-*/=q]")) {
            System.out.println("Invalid input (+, -, /, *, = or Q to quit):");
            operator = input.nextLine().trim().toLowerCase();
        }
        return operator;
    }

    public Fraction getFraction(Scanner input) {
        System.out.println("Please enter a fraction (a/b) or integer (a):");
        String expression = input.nextLine();
        while (!validFraction(expression)) {
            System.out.println("Invalid fraction. Prease enter (a/b) or (a), " +
                    "where a and b are integers and b is not zero:");
            expression = input.nextLine();
        }
        String [] args = expression.replaceAll("\\s+", "").split("/");
        if (args.length == 2)
            return new Fraction(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        else
            return new Fraction(Integer.parseInt(args[0]), 1);
    }
}
