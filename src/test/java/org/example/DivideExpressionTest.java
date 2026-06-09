package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes para DivideExpression")
class DivideExpressionTest {

    @Test
    @DisplayName("Deve dividir dois números positivos")
    void testDivideTwoPositiveNumbers() {
        Expression expression = new DivideExpression(
            new NumberExpression(20),
            new NumberExpression(4)
        );
        assertEquals(5.0, expression.interpret());
    }

    @Test
    @DisplayName("Deve dividir resultando em número decimal")
    void testDivideResultDecimal() {
        Expression expression = new DivideExpression(
            new NumberExpression(10),
            new NumberExpression(3)
        );
        assertEquals(10.0 / 3, expression.interpret(), 0.0001);
    }

    @Test
    @DisplayName("Deve dividir número positivo com negativo")
    void testDividePositiveWithNegative() {
        Expression expression = new DivideExpression(
            new NumberExpression(10),
            new NumberExpression(-2)
        );
        assertEquals(-5.0, expression.interpret());
    }

    @Test
    @DisplayName("Deve dividir dois números negativos")
    void testDivideTwoNegativeNumbers() {
        Expression expression = new DivideExpression(
            new NumberExpression(-20),
            new NumberExpression(-4)
        );
        assertEquals(5.0, expression.interpret());
    }

    @Test
    @DisplayName("Deve dividir zero por número")
    void testDivideZeroByNumber() {
        Expression expression = new DivideExpression(
            new NumberExpression(0),
            new NumberExpression(5)
        );
        assertEquals(0.0, expression.interpret());
    }

    @Test
    @DisplayName("Deve lançar exceção ao dividir por zero")
    void testDivideByZeroThrowsException() {
        Expression expression = new DivideExpression(
            new NumberExpression(15),
            new NumberExpression(0)
        );
        assertThrows(ArithmeticException.class, expression::interpret);
    }

    @Test
    @DisplayName("Deve retornar mensagem de erro correto ao dividir por zero")
    void testDivideByZeroErrorMessage() {
        Expression expression = new DivideExpression(
            new NumberExpression(20),
            new NumberExpression(0)
        );
        ArithmeticException exception = assertThrows(
            ArithmeticException.class,
            expression::interpret
        );
        assertEquals("Divisão por zero!", exception.getMessage());
    }

    @Test
    @DisplayName("Deve dividir números decimais")
    void testDivideDecimalNumbers() {
        Expression expression = new DivideExpression(
            new NumberExpression(10.5),
            new NumberExpression(2.0)
        );
        assertEquals(5.25, expression.interpret(), 0.01);
    }

    @Test
    @DisplayName("Deve dividir expressões aninhadas")
    void testDivideNestedExpressions() {
        // ((10 + 5) - 3) / 2 = 12 / 2 = 6
        Expression expression = new DivideExpression(
            new SubtractExpression(
                new AddExpression(new NumberExpression(10), new NumberExpression(5)),
                new NumberExpression(3)
            ),
            new NumberExpression(2)
        );
        assertEquals(6.0, expression.interpret());
    }

    @Test
    @DisplayName("Deve retornar string formatada")
    void testToString() {
        Expression expression = new DivideExpression(
            new NumberExpression(20),
            new NumberExpression(4)
        );
        assertTrue(expression.toString().contains("/"));
    }
}

