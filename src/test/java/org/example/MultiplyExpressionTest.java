package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes para MultiplyExpression")
class MultiplyExpressionTest {

    @Test
    @DisplayName("Deve multiplicar dois números positivos")
    void testMultiplyTwoPositiveNumbers() {
        Expression expression = new MultiplyExpression(
            new NumberExpression(7),
            new NumberExpression(6)
        );
        assertEquals(42.0, expression.interpret());
    }

    @Test
    @DisplayName("Deve multiplicar número positivo com negativo")
    void testMultiplyPositiveWithNegative() {
        Expression expression = new MultiplyExpression(
            new NumberExpression(5),
            new NumberExpression(-3)
        );
        assertEquals(-15.0, expression.interpret());
    }

    @Test
    @DisplayName("Deve multiplicar dois números negativos")
    void testMultiplyTwoNegativeNumbers() {
        Expression expression = new MultiplyExpression(
            new NumberExpression(-5),
            new NumberExpression(-3)
        );
        assertEquals(15.0, expression.interpret());
    }

    @Test
    @DisplayName("Deve multiplicar por zero")
    void testMultiplyByZero() {
        Expression expression = new MultiplyExpression(
            new NumberExpression(10),
            new NumberExpression(0)
        );
        assertEquals(0.0, expression.interpret());
    }

    @Test
    @DisplayName("Deve multiplicar números decimais")
    void testMultiplyDecimalNumbers() {
        Expression expression = new MultiplyExpression(
            new NumberExpression(2.5),
            new NumberExpression(4)
        );
        assertEquals(10.0, expression.interpret());
    }

    @Test
    @DisplayName("Deve multiplicar expressões aninhadas")
    void testMultiplyNestedExpressions() {
        // (5 + 3) * 2
        Expression expression = new MultiplyExpression(
            new AddExpression(new NumberExpression(5), new NumberExpression(3)),
            new NumberExpression(2)
        );
        assertEquals(16.0, expression.interpret());
    }

    @Test
    @DisplayName("Deve respeitar precedência com subtração")
    void testMultiplyPrecedence() {
        // 10 - 3 * 2 (sem parênteses, interpretando como (10 - 3) * 2)
        Expression expression = new MultiplyExpression(
            new SubtractExpression(new NumberExpression(10), new NumberExpression(3)),
            new NumberExpression(2)
        );
        assertEquals(14.0, expression.interpret());
    }

    @Test
    @DisplayName("Deve retornar string formatada")
    void testToString() {
        Expression expression = new MultiplyExpression(
            new NumberExpression(7),
            new NumberExpression(6)
        );
        assertTrue(expression.toString().contains("*"));
    }
}

