package org.example;

/**
 * Expressão não-terminal que representa uma divisão
 */
public class DivideExpression implements Expression {
    private Expression left;
    private Expression right;

    public DivideExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double interpret() {
        double rightValue = right.interpret();
        if (rightValue == 0) {
            throw new ArithmeticException("Divisão por zero!");
        }
        return left.interpret() / rightValue;
    }

    @Override
    public String toString() {
        return "(" + left + " / " + right + ")";
    }
}

