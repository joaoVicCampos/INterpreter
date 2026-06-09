package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes para SubtractExpression")
class SubtractExpressionTest {

    @Test
    @DisplayName("Deve subtrair dois números positivos")
    void testSubtractTwoPositiveNumbers() {
        Expression expression = new SubtractExpression(
            new NumberExpression(10),
            new NumberExpression(3)
        );
        assertEquals(7.0, expression.interpret());
    }

    @Test
    @DisplayName("Deve subtrair resultando em número negativo")
    void testSubtractResultNegative() {
        Expression expression = new SubtractExpression(
            new NumberExpression(3),
            new NumberExpression(10)
        );
        assertEquals(-7.0, expression.interpret());
    }

    @Test
    @DisplayName("Deve subtrair número negativo (adição)")
    void testSubtractNegativeNumber() {
        Expression expression = new SubtractExpression(
            new NumberExpression(10),
            new NumberExpression(-5)
        );
        assertEquals(15.0, expression.interpret());
    }

    @Test
    @DisplayName("Deve subtrair com zero")
    void testSubtractWithZero() {
        Expression expression = new SubtractExpression(
            new NumberExpression(10),
            new NumberExpression(0)
        );
        assertEquals(10.0, expression.interpret());
    }

    @Test
    @DisplayName("Deve subtrair números decimais")
    void testSubtractDecimalNumbers() {
        Expression expression = new SubtractExpression(
            new NumberExpression(10.5),
            new NumberExpression(3.2)
        );
        assertEquals(7.3, expression.interpret(), 0.01);
    }

    @Test
    @DisplayName("Deve subtrair expressões aninhadas")
    void testSubtractNestedExpressions() {
        // (10 - 3) - (2 - 1)
        Expression expression = new SubtractExpression(
            new SubtractExpression(new NumberExpression(10), new NumberExpression(3)),
            new SubtractExpression(new NumberExpression(2), new NumberExpression(1))
        );
        assertEquals(6.0, expression.interpret());
    }

    @Test
    @DisplayName("Deve retornar string formatada")
    void testToString() {
        Expression expression = new SubtractExpression(
            new NumberExpression(10),
            new NumberExpression(3)
        );
        assertTrue(expression.toString().contains("-"));
    }
}

