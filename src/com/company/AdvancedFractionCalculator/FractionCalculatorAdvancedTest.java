package com.company.AdvancedFractionCalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

class FractionCalculatorAdvancedTest {

    @Test
    void getFunction() {
    }

    @Test
    void evaluate() {
        FractionCalculatorAdvanced calc = new FractionCalculatorAdvanced();
        Fraction frac1 = new Fraction(5,3);
        Fraction frac2 = new Fraction(7,3);
        Expression expression1 = new Expression("+", frac1, frac2);
        Expression expression2 = new Expression("-", frac1, frac2);
        Expression expression3 = new Expression("=", frac1, frac2);
        Expression expression4 = new Expression("=", frac1, frac1);

        Assertions.assertEquals("4", calc.evaluate(expression1).toString());
        Assertions.assertEquals("-2/3", calc.evaluate(expression2).toString());
        Assertions.assertEquals("false", calc.evaluate(expression3).toString());
        Assertions.assertEquals("true", calc.evaluate(expression4).toString());
    }

    @Test
    void validFraction() {
        FractionCalculatorAdvanced calc = new FractionCalculatorAdvanced();

        Assertions.assertEquals(false, calc.validFraction("11/-3"));
        Assertions.assertEquals(true, calc.validFraction("-11/3"));
        Assertions.assertEquals(false, calc.validFraction("11/0"));
        Assertions.assertEquals(true, calc.validFraction("11"));
    }

    @Test
    void validExpression() {
        FractionCalculatorAdvanced calc = new FractionCalculatorAdvanced();

        Assertions.assertEquals(true, calc.validExpression("33 / 11"));
        Assertions.assertEquals(true, calc.validExpression("1/2 * 4/3"));
        Assertions.assertEquals(true, calc.validExpression("q"));
        Assertions.assertEquals(true, calc.validExpression("11/14 / 7/11"));
        Assertions.assertEquals(true, calc.validExpression("1/2 * 2"));
        Assertions.assertEquals(true, calc.validExpression("-3 * 4/3"));
        Assertions.assertEquals(false, calc.validExpression("3 * 4/-3"));
        Assertions.assertEquals(true, calc.validExpression("3 = 9/3"));
    }

    @Test
    void stringToFraction() {
        FractionCalculatorAdvanced calc = new FractionCalculatorAdvanced();

        Assertions.assertEquals(new Fraction(11,3), calc.stringToFraction("11/3"));
        Assertions.assertEquals(new Fraction(11,1), calc.stringToFraction("11"));
        Assertions.assertEquals(new Fraction(-11,2), calc.stringToFraction("-11/2"));
    }

    @Test
    void getExpression() {
        FractionCalculatorAdvanced calc = new FractionCalculatorAdvanced();
        Expression expression1 = calc.getExpression(new Scanner("q"));
        Expression expression2 = calc.getExpression(new Scanner("11/14 / 7/11"));
        Expression expression3 = calc.getExpression(new Scanner("33 / 11"));
        Expression expression4 = calc.getExpression(new Scanner("33/11 = 3"));
        Expression expression5 = calc.getExpression(new Scanner("5/3 + 10/6"));

        Assertions.assertEquals("0 q 0", expression1.toString());
        Assertions.assertEquals("11/14 / 7/11", expression2.toString());
        Assertions.assertEquals("33 / 11", expression3.toString());
        Assertions.assertEquals("33/11 = 3", expression4.toString());
        Assertions.assertEquals("5/3 + 10/6", expression5.toString());
    }
}