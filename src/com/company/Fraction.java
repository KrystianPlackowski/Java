package com.company;

import static java.lang.Integer.max;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator < 0) {
            this.numerator = -numerator;
            this.denominator = -denominator;
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    public Fraction(int numerator) {
        this(numerator, 1);
    }

    public Fraction() {
        this(0, 1);
    }

    public int getNumerator() {
        return this.numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    @Override
    public String toString() {
        if (this.denominator == 0) {
            return "Undefined";
        }

        if (this.denominator == 1) {
            return String.format("%d", this.numerator);
        }
        return String.format("%d/%d", this.numerator, this.denominator);
    }

    public double toDouble() {
        return this.numerator * 1.0 / this.denominator;
    }

    public Fraction add(Fraction other) {
        Fraction newFraction = new Fraction(
                this.getNumerator() * other.getDenominator() +
                        other.getNumerator() * this.getDenominator(),
                this.getDenominator() * other.getDenominator());
        newFraction.toLowestTerms();
        return newFraction;
    }

    public Fraction substract(Fraction other) {
        Fraction newFraction = new Fraction(
                this.getNumerator() * other.getDenominator() -
                        other.getNumerator() * this.getDenominator(),
                this.getDenominator() * other.getDenominator());
        newFraction.toLowestTerms();
        return newFraction;
    }

    public Fraction multiply(Fraction other) {
        Fraction newFraction = new Fraction(
                this.getNumerator() * other.getNumerator(),
                this.getDenominator() * other.getDenominator());
        newFraction.toLowestTerms();
        return newFraction;
    }

    public Fraction divide(Fraction other) {
        Fraction newFraction = new Fraction(
                this.getNumerator() * other.getDenominator(),
                this.getDenominator() * other.getNumerator());
        newFraction.toLowestTerms();
        return newFraction;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Fraction)) {
            return false;
        }

        Fraction frac1 = new Fraction(((Fraction) other).numerator, ((Fraction) other).denominator);
        Fraction frac2 = new Fraction(this.numerator, this.denominator);
        frac1.toLowestTerms();
        frac2.toLowestTerms();
        return (frac1.numerator == 0 && frac2.numerator == 0) ||
                (frac1.numerator == frac2.numerator && frac1.denominator == frac2.denominator);
    }

    public void toLowestTerms() {
        if (this.denominator == 0) {
            this.numerator = 1;
            return;
        }

        int commonDivisor = gcd(this.numerator, this.denominator);
        this.numerator /= commonDivisor;
        this.denominator /= commonDivisor;

        if (this.denominator < 0) {
            this.numerator *= -1;
            this.denominator *= -1;
        }
    }

    public static int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }

        while (a != 0 && b != 0) {
            int c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
}
