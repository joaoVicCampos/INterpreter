package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes de Integração - Expressões Complexas")
class ExpressionIntegrationTest {

    @Test
    @DisplayName("Deve calcular: (5 + 3) * 2 = 16")
    void testComplexExpression1() {
        Expression expression = new MultiplyExpression(
            new AddExpression(new NumberExpression(5), new NumberExpression(3)),
            new NumberExpression(2)
        );
        assertEquals(16.0, expression.interpret());
    }

    @Test
    @DisplayName("Deve calcular: ((10 + 5) - 3) / 2 = 6")
    void testComplexExpression2() {
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
    @DisplayName("Deve calcular: (20 / 4) + (3 * 2) = 11")
    void testComplexExpression3() {
        Expression expression = new AddExpression(
            new DivideExpression(new NumberExpression(20), new NumberExpression(4)),
            new MultiplyExpression(new NumberExpression(3), new NumberExpression(2))
        );
        assertEquals(11.0, expression.interpret());
    }

    @Test
    @DisplayName("Deve calcular: ((100 / 5) - 10) * 2 = 20")
    void testComplexExpression4() {
        Expression expression = new MultiplyExpression(
            new SubtractExpression(
                new DivideExpression(new NumberExpression(100), new NumberExpression(5)),
                new NumberExpression(10)
            ),
            new NumberExpression(2)
        );
        assertEquals(20.0, expression.interpret());
    }

    @Test
    @DisplayName("Deve calcular: (8 * 3) - (10 + 4) = 14")
    void testComplexExpression5() {
        Expression expression = new SubtractExpression(
            new MultiplyExpression(new NumberExpression(8), new NumberExpression(3)),
            new AddExpression(new NumberExpression(10), new NumberExpression(4))
        );
        assertEquals(14.0, expression.interpret());
    }

    @Test
    @DisplayName("Deve calcular: (50 - 20) / (10 - 5) = 6")
    void testComplexExpression6() {
        Expression expression = new DivideExpression(
            new SubtractExpression(new NumberExpression(50), new NumberExpression(20)),
            new SubtractExpression(new NumberExpression(10), new NumberExpression(5))
        );
        assertEquals(6.0, expression.interpret());
    }

    @Test
    @DisplayName("Deve calcular: ((2 + 3) * (4 + 1)) / 5 = 5")
    void testComplexExpression7() {
        Expression expression = new DivideExpression(
            new MultiplyExpression(
                new AddExpression(new NumberExpression(2), new NumberExpression(3)),
                new AddExpression(new NumberExpression(4), new NumberExpression(1))
            ),
            new NumberExpression(5)
        );
        assertEquals(5.0, expression.interpret());
    }

    @Test
    @DisplayName("Deve manter precisão com números decimais em expressão complexa")
    void testDecimalPrecision() {
        // (5.5 + 2.5) * 2 = 16.0
        Expression expression = new MultiplyExpression(
            new AddExpression(new NumberExpression(5.5), new NumberExpression(2.5)),
            new NumberExpression(2)
        );
        assertEquals(16.0, expression.interpret());
    }

    @Test
    @DisplayName("Deve avaliar com números negativos")
    void testNegativeNumbers() {
        // (-10 + 5) * (-2) = 10
        Expression expression = new MultiplyExpression(
            new AddExpression(new NumberExpression(-10), new NumberExpression(5)),
            new NumberExpression(-2)
        );
        assertEquals(10.0, expression.interpret());
    }

    @Test
    @DisplayName("Deve retornar string corretamente formatada para expressão complexa")
    void testComplexToString() {
        Expression expression = new MultiplyExpression(
            new AddExpression(new NumberExpression(5), new NumberExpression(3)),
            new NumberExpression(2)
        );
        String result = expression.toString();
        assertTrue(result.contains("+"));
        assertTrue(result.contains("*"));
    }
}

