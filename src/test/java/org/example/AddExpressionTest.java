package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes para AddExpression")
class AddExpressionTest {

    @Test
    @DisplayName("Deve somar dois números positivos")
    void testAddTwoPositiveNumbers() {
        Expression expression = new AddExpression(
            new NumberExpression(5),
            new NumberExpression(3)
        );
        assertEquals(8.0, expression.interpret());
    }

    @Test
    @DisplayName("Deve somar número positivo com negativo")
    void testAddPositiveWithNegative() {
        Expression expression = new AddExpression(
            new NumberExpression(10),
            new NumberExpression(-3)
        );
        assertEquals(7.0, expression.interpret());
    }

    @Test
    @DisplayName("Deve somar dois números negativos")
    void testAddTwoNegativeNumbers() {
        Expression expression = new AddExpression(
            new NumberExpression(-5),
            new NumberExpression(-3)
        );
        assertEquals(-8.0, expression.interpret());
    }

    @Test
    @DisplayName("Deve somar com zero")
    void testAddWithZero() {
        Expression expression = new AddExpression(
            new NumberExpression(10),
            new NumberExpression(0)
        );
        assertEquals(10.0, expression.interpret());
    }

    @Test
    @DisplayName("Deve somar números decimais")
    void testAddDecimalNumbers() {
        Expression expression = new AddExpression(
            new NumberExpression(2.5),
            new NumberExpression(3.5)
        );
        assertEquals(6.0, expression.interpret());
    }

    @Test
    @DisplayName("Deve somar expressões aninhadas")
    void testAddNestedExpressions() {
        // (5 + 3) + (2 + 1)
        Expression expression = new AddExpression(
            new AddExpression(new NumberExpression(5), new NumberExpression(3)),
            new AddExpression(new NumberExpression(2), new NumberExpression(1))
        );
        assertEquals(11.0, expression.interpret());
    }

    @Test
    @DisplayName("Deve retornar string formatada")
    void testToString() {
        Expression expression = new AddExpression(
            new NumberExpression(5),
            new NumberExpression(3)
        );
        assertTrue(expression.toString().contains("+"));
    }
}

