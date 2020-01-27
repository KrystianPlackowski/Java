package com.company.FractionCalculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("This program is a fraction calculator");
        System.out.println("It will add, substact, multiply and divide fractions until you type Q to quit.");
        System.out.println("Please enter your fractions in the form a/b, where a and b are integers");

        Scanner input = new Scanner(System.in);
        FractionCalculator calc = new FractionCalculator();
        while(true) {
            String operation = calc.getOperation(input);
            if (operation.equals("q")) {
                break;
            }

            Fraction firstFraction = calc.getFraction(input);
            Fraction secondFraction = calc.getFraction(input);
            Expression expression = new Expression(operation, firstFraction, secondFraction);
            Object result = calc.evaluate(expression);
            CalculationResultViewer viewer = new CalculationResultViewer(expression, result);
            viewer.displayResult();
        }
    }
}
