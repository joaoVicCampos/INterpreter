package org.example;

/**
 * Expressão não-terminal que representa uma multiplicação
 */
public class MultiplyExpression implements Expression {
    private Expression left;
    private Expression right;

    public MultiplyExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double interpret() {
        return left.interpret() * right.interpret();
    }

    @Override
    public String toString() {
        return "(" + left + " * " + right + ")";
    }
}

