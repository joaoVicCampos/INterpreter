package org.example;

/**
 * Expressão não-terminal que representa uma adição
 * Non-terminal expression no padrão Interpreter
 */
public class AddExpression implements Expression {
    private Expression left;
    private Expression right;

    public AddExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public double interpret() {
        return left.interpret() + right.interpret();
    }

    @Override
    public String toString() {
        return "(" + left + " + " + right + ")";
    }
}

