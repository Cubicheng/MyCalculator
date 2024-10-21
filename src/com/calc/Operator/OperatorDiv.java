package com.calc.Operator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class OperatorDiv extends Operator {

    public OperatorDiv(BigDecimal number_A, BigDecimal number_B) {
        super(number_A, number_B);
    }

    @Override
    public BigDecimal getResult() {
        if(number_B.equals(BigDecimal.ZERO)) {
            throw new IllegalArgumentException("Cannot divide by zero.");
        }
        return number_A.divide(number_B,20, RoundingMode.HALF_UP);
    }
}
