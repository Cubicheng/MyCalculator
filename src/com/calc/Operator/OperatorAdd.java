package com.calc.Operator;

import java.math.BigDecimal;

public class OperatorAdd extends Operator {

    public OperatorAdd(BigDecimal number_A, BigDecimal number_B) {
        super(number_A, number_B);
    }

    @Override
    public BigDecimal getResult() {
        return number_A.add(number_B);
    }
}
