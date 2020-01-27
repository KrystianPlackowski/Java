package com.company.FractionCalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

class FractionCalculatorTest {

    @Test
    void getOperation() {
        Scanner input1 = new Scanner("  * ");
        Scanner input2 = new Scanner("/5 \n +");
        FractionCalculator calc = new FractionCalculator();

        Assertions.assertEquals("*", calc.getOperation(input1));
        Assertions.assertEquals("+", calc.getOperation(input2));
    }

    @Test
    void getFunction() {
        Fraction frac1 = new Fraction(3,4);
        Fraction frac2 = new Fraction(5, 7);
        FractionCalculator calc = new FractionCalculator();

        Assertions.assertEquals(new Fraction(41,28),
                calc.getFunction("+").apply(frac1, frac2));
        Assertions.assertEquals(new Fraction(1,28),
                calc.getFunction("-").apply(frac1, frac2));
        Assertions.assertEquals(new Fraction(15,28),
                calc.getFunction("*").apply(frac1, frac2));
        Assertions.assertEquals(new Fraction(21,20),
                calc.getFunction("/").apply(frac1, frac2));
        Assertions.assertEquals(false,
                calc.getFunction("=").apply(frac1, frac2));
        Assertions.assertEquals(true,
                calc.getFunction("=").apply(frac1, frac1));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> calc.getFunction("I'm not an operator").apply(frac1, frac2));
    }

    @Test
    void validFraction() {
        FractionCalculator calc = new FractionCalculator();

        Assertions.assertEquals(true, calc.validFraction("5/4"));
        Assertions.assertEquals(true, calc.validFraction("- 50 /4  "));
        Assertions.assertEquals(false, calc.validFraction("--5/4"));
        Assertions.assertEquals(false, calc.validFraction("5/4.1"));
        Assertions.assertEquals(false, calc.validFraction("5/-4"));
        Assertions.assertEquals(true, calc.validFraction("5"));
        Assertions.assertEquals(false, calc.validFraction("5//4"));
        Assertions.assertEquals(false, calc.validFraction("5 3/4"));
        Assertions.assertEquals(true, calc.validFraction("50/10"));
        Assertions.assertEquals(false, calc.validFraction("50/0"));
        Assertions.assertEquals(true, calc.validFraction("0/10"));
    }

    @Test
    void getFraction() {
        Scanner input1 = new Scanner("-5 /  6");
        Scanner input2 = new Scanner("-5 / 0 \n -1/2");
        Scanner input3 = new Scanner("-5");
        FractionCalculator calc = new FractionCalculator();

        Assertions.assertEquals("-5/6", calc.getFraction(input1).toString());
        Assertions.assertEquals("-1/2", calc.getFraction(input2).toString());
        Assertions.assertEquals("-5", calc.getFraction(input3).toString());
    }
}