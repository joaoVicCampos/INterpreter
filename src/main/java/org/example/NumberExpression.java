package org.example;

/**
 * Expressão terminal que representa um número
 * Terminal expression no padrão Interpreter
 */
public class NumberExpression implements Expression {
    private double number;

    public NumberExpression(double number) {
        this.number = number;
    }

    @Override
    public double interpret() {
        return this.number;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}

