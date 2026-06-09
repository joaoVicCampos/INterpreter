package org.example;

/**
 * Classe principal - Demonstra o padrão de projeto Interpreter
 * Interpretador simples para avaliar expressões matemáticas
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== Sistema de Interpretação de Expressões Matemáticas ===\n");

        // Exemplo 1: 5 + 3 = 8
        System.out.println("Exemplo 1: 5 + 3");
        Expression expression1 = new AddExpression(
            new NumberExpression(5),
            new NumberExpression(3)
        );
        System.out.println("Expressão: " + expression1);
        System.out.println("Resultado: " + expression1.interpret());
        System.out.println();

        // Exemplo 2: 10 - 4 = 6
        System.out.println("Exemplo 2: 10 - 4");
        Expression expression2 = new SubtractExpression(
            new NumberExpression(10),
            new NumberExpression(4)
        );
        System.out.println("Expressão: " + expression2);
        System.out.println("Resultado: " + expression2.interpret());
        System.out.println();

        // Exemplo 3: 7 * 6 = 42
        System.out.println("Exemplo 3: 7 * 6");
        Expression expression3 = new MultiplyExpression(
            new NumberExpression(7),
            new NumberExpression(6)
        );
        System.out.println("Expressão: " + expression3);
        System.out.println("Resultado: " + expression3.interpret());
        System.out.println();

        // Exemplo 4: 20 / 4 = 5
        System.out.println("Exemplo 4: 20 / 4");
        Expression expression4 = new DivideExpression(
            new NumberExpression(20),
            new NumberExpression(4)
        );
        System.out.println("Expressão: " + expression4);
        System.out.println("Resultado: " + expression4.interpret());
        System.out.println();

        // Exemplo 5: Expressão complexa: (5 + 3) * 2 = 16
        System.out.println("Exemplo 5: (5 + 3) * 2");
        Expression expression5 = new MultiplyExpression(
            new AddExpression(new NumberExpression(5), new NumberExpression(3)),
            new NumberExpression(2)
        );
        System.out.println("Expressão: " + expression5);
        System.out.println("Resultado: " + expression5.interpret());
        System.out.println();

        // Exemplo 6: Expressão mais complexa: ((10 + 5) - 3) / 2 = 6.0
        System.out.println("Exemplo 6: ((10 + 5) - 3) / 2");
        Expression expression6 = new DivideExpression(
            new SubtractExpression(
                new AddExpression(new NumberExpression(10), new NumberExpression(5)),
                new NumberExpression(3)
            ),
            new NumberExpression(2)
        );
        System.out.println("Expressão: " + expression6);
        System.out.println("Resultado: " + expression6.interpret());
        System.out.println();

        // Exemplo 7: Tratamento de erro - Divisão por zero
        System.out.println("Exemplo 7: 15 / 0 (Divisão por Zero)");
        Expression expression7 = new DivideExpression(
            new NumberExpression(15),
            new NumberExpression(0)
        );
        System.out.println("Expressão: " + expression7);
        try {
            System.out.println("Resultado: " + expression7.interpret());
        } catch (ArithmeticException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
