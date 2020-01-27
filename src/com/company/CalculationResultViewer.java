package com.company;

public class CalculationResultViewer {
    Expression expression;
    Object result;

    public CalculationResultViewer(Expression expression, Object result) {
        this.expression = expression;
        this.result = result;
    }

    public void displayResult() {
        String display = String.format("%s %s %s is %s\n",
                expression.getFirstFrac().toString(),
                expression.getOperation(),
                expression.getSecondFrac().toString(),
                result.toString());

        if (result instanceof Fraction) {
            System.out.print(display.replace("is", "="));
        } else {
            System.out.print(display);
        }
    }
}