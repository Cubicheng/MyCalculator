package com.calc.Operator;

import java.math.BigDecimal;

public class OperatorSub extends Operator {

    public OperatorSub(BigDecimal number_A, BigDecimal number_B) {
        super(number_A, number_B);
    }

    @Override
    public BigDecimal getResult() {
        return number_A.subtract(number_B);
    }
}