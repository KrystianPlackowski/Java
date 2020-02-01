package com.company.AdvancedFractionCalculator.tests;

import com.company.AdvancedFractionCalculator.Fraction;
import org.junit.jupiter.api.Assertions;

class FractionTest {

    @org.junit.jupiter.api.Test
    void getNumerator() {
        Fraction frac1 = new Fraction(4,-14);
        Assertions.assertEquals(-4, frac1.getNumerator());
    }

    @org.junit.jupiter.api.Test
    void getDenominator() {
        Fraction frac1 = new Fraction(4,-14);
        Assertions.assertEquals(14, frac1.getDenominator());
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        Fraction frac1 = new Fraction(4,-14);
        Fraction frac2 = new Fraction(4,-1);
        Fraction frac3 = new Fraction(10,6);
        Assertions.assertEquals("-4/14", frac1.toString());
        Assertions.assertEquals("-4", frac2.toString());
        Assertions.assertEquals("10/6", frac3.toString());
    }

    @org.junit.jupiter.api.Test
    void toDouble() {
        Fraction frac1 = new Fraction(4,-10);
        Assertions.assertEquals(-0.4, frac1.toDouble(), 0.00001);
    }

    @org.junit.jupiter.api.Test
    void add() {
        Fraction frac1 = new Fraction(1,6);
        Fraction frac2 = new Fraction(1,-2);
        Assertions.assertEquals("-1/3", frac1.add(frac2).toString());
    }

    @org.junit.jupiter.api.Test
    void substract() {
        Fraction frac1 = new Fraction(1,3);
        Fraction frac2 = new Fraction(1,2);
        Assertions.assertEquals("-1/6", frac1.substract(frac2).toString());
    }

    @org.junit.jupiter.api.Test
    void multiply() {
        Fraction frac1 = new Fraction(2,-3);
        Fraction frac2 = new Fraction(4,8);
        Assertions.assertEquals("-1/3", frac1.multiply(frac2).toString());
    }

    @org.junit.jupiter.api.Test
    void divide() {
        Fraction frac1 = new Fraction(2,-3);
        Fraction frac2 = new Fraction(4,3);
        Fraction frac3 = new Fraction(0,2);

        Assertions.assertEquals("-1/2", frac1.divide(frac2).toString());
        Assertions.assertEquals("Undefined", frac2.divide(frac3).toString());
        Assertions.assertEquals("Undefined", new Fraction(2,0).toString());
    }

    @org.junit.jupiter.api.Test
    void testEquals() {
        Fraction frac1 = new Fraction(2,-4);
        Fraction frac2 = new Fraction(-1,2);
        Fraction frac3 = new Fraction(0,2);
        Fraction frac4 = new Fraction(0,-5);

        Assertions.assertEquals(true, frac1.equals(frac2));
        Assertions.assertEquals(true, frac3.equals(frac4));
        Assertions.assertEquals(false, frac1.equals(new String("I'm not type Fraction")));
    }

    @org.junit.jupiter.api.Test
    void toLowestTerms() {
        Fraction frac1 = new Fraction(105,147);
        Fraction frac2 = new Fraction(0,2);
        frac1.toLowestTerms();
        frac2.toLowestTerms();

        Assertions.assertEquals("5/7", frac1.toString());
        Assertions.assertEquals("0", frac2.toString());
    }

    @org.junit.jupiter.api.Test
    void gcd() {
    }
}