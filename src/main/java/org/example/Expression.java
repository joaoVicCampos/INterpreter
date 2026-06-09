package org.example;

/**
 * Interface que define a estrutura básica de uma expressão no padrão Interpreter
 * Toda expressão deve implementar o método interpret()
 */
public interface Expression {
    /**
     * Interpreta e avalia a expressão
     * @return o resultado da interpretação
     */
    double interpret();
}

