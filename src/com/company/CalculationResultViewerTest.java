package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

class CalculationResultViewerTest {
    private ByteArrayOutputStream outContent;

    private void setCleanOutputStream() {
        this.outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void displayResult() {
        FractionCalculatorAdvanced calc = new FractionCalculatorAdvanced();
        Expression expression1 = calc.getExpression(new Scanner("5/3 = 10/6"));
        Expression expression2 = calc.getExpression(new Scanner("5/3 + 10/6"));
        CalculationResultViewer viewer1 = new CalculationResultViewer(expression1, calc.evaluate(expression1));
        CalculationResultViewer viewer2 = new CalculationResultViewer(expression2, calc.evaluate(expression2));

        this.setCleanOutputStream();
        viewer1.displayResult();
        Assertions.assertEquals("5/3 = 10/6 is true\n", outContent.toString());

        this.setCleanOutputStream();
        viewer2.displayResult();
        Assertions.assertEquals("5/3 + 10/6 = 10/3\n", outContent.toString());
    }
}