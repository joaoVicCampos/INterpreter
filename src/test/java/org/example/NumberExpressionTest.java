package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes para NumberExpression")
class NumberExpressionTest {

    @Test
    @DisplayName("Deve interpretar um número inteiro positivo")
    void testInterpretPositiveInteger() {
        Expression expression = new NumberExpression(5);
        assertEquals(5.0, expression.interpret());
    }

    @Test
    @DisplayName("Deve interpretar um número inteiro negativo")
    void testInterpretNegativeInteger() {
        Expression expression = new NumberExpression(-10);
        assertEquals(-10.0, expression.interpret());
    }

    @Test
    @DisplayName("Deve interpretar número decimal")
    void testInterpretDecimal() {
        Expression expression = new NumberExpression(3.14);
        assertEquals(3.14, expression.interpret());
    }

    @Test
    @DisplayName("Deve interpretar zero")
    void testInterpretZero() {
        Expression expression = new NumberExpression(0);
        assertEquals(0.0, expression.interpret());
    }

    @Test
    @DisplayName("Deve retornar string com o valor do número")
    void testToString() {
        Expression expression = new NumberExpression(42);
        assertEquals("42.0", expression.toString());
    }
}

