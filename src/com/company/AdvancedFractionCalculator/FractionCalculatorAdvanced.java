package com.company.AdvancedFractionCalculator;

import java.util.Scanner;
import java.util.function.BiFunction;

public class FractionCalculatorAdvanced {

    public FractionCalculatorAdvanced() {
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
        String singleNumber = "[-]?(0|[1-9][0-9]*)";
        String fractionNumber = "[-]?(0|[1-9][0-9]*)/([1-9][0-9]*)";
        return input.matches(String.format("((%s)|(%s))", singleNumber, fractionNumber));
    }

    public boolean validExpression(String input) {
        String singleNumber = "[-]?(0|[1-9][0-9]*)";
        String fractionNumber = "[-]?(0|[1-9][0-9]*)/([1-9][0-9]*)";
        return input.matches(String.format("((%s)|(%s)) [+\\-*/=] ((%s)|(%s))",
                singleNumber, fractionNumber, singleNumber, fractionNumber)) ||
                input.matches("q|Q");
    }

    public Fraction stringToFraction(String fraction) {
        String [] args = fraction.split("/");
        if (args.length == 1) {
            return new Fraction(Integer.parseInt(args[0]), 1);
        } else {
            return new Fraction(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        }
    }

    public Expression getExpression(Scanner input) {
        System.out.println("Enter an operation (q to quit):");
        String expression = input.nextLine();
        while (!validExpression(expression)) {
            System.out.println("Invalid operation. Must be \"[FRAC] [OPERATION] [FRAC]\".");
            System.out.println("Enter an operation (q to quit):");
            expression = input.nextLine();
        }
        String[] args = expression.split(" ");
        if (args.length == 1)
            return new Expression("q", new Fraction(), new Fraction());
        else {
            return new Expression(args[1], stringToFraction(args[0]), stringToFraction(args[2]));
        }
    }
}