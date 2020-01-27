package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("This program is a fraction calculator");
        System.out.println("It will add, substact, multiply and divide fractions until you type Q to quit.");
        System.out.println("Please enter your fractions in the form a/b, where a and b are integers");

        Scanner input = new Scanner(System.in);
        FractionCalculatorAdvanced calc = new FractionCalculatorAdvanced();
        while(true) {
            Expression expression = calc.getExpression(input);
            if (expression.userTypedQuit()) {
                break;
            }

            Object result = calc.evaluate(expression);
            CalculationResultViewer viewer = new CalculationResultViewer(expression, result);
            viewer.displayResult();
        }
    }
}
