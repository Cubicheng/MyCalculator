package com.calc.Operator;

import java.math.BigDecimal;

public class OperatorFactory {
    public static Operator createOperator(BigDecimal number_A, BigDecimal number_B, Character operator) {
        return switch (operator) {
            case '+' -> new OperatorAdd(number_B, number_A);
            case '-' -> new OperatorSub(number_B, number_A);
            case '*' -> new OperatorMul(number_B, number_A);
            case '/' -> new OperatorDiv(number_B, number_A);
            default -> throw new IllegalArgumentException("Invalid operator: " + operator);
        };
    }
}
