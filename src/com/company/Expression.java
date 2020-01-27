package com.company;

import java.util.function.BiFunction;

public class Expression {
    String operation;
    Fraction firstFrac;
    Fraction secondFrac;

    public Expression(String operator, Fraction firstFrac, Fraction secondFrac) {
        this.operation = operator;
        this.firstFrac = firstFrac;
        this.secondFrac = secondFrac;
    }

    public boolean userTypedQuit() {
        return this.operation == "q";
    }

    public Fraction getFirstFrac() {
        return this.firstFrac;
    }

    public Fraction getSecondFrac() {
        return this.secondFrac;
    }

    public String getOperation() {
        return this.operation;
    }

    public String toString() {
        return String.format("%s %s %s", firstFrac.toString(), operation, secondFrac.toString());
    }
}