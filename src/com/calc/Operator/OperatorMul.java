package com.calc.Operator;

import java.math.BigDecimal;

public class OperatorMul extends Operator {

    public OperatorMul(BigDecimal number_A, BigDecimal number_B) {
        super(number_A, number_B);
    }

    @Override
    public BigDecimal getResult() {
        return number_A.multiply(number_B);
    }
}
