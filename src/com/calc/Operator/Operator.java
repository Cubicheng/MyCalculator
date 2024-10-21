package com.calc.Operator;

import java.math.BigDecimal;

public class Operator {
    protected BigDecimal number_A=new BigDecimal("0");
    protected BigDecimal number_B=new BigDecimal("0");

    public Operator(BigDecimal number_A, BigDecimal number_B) {
        this.number_A = number_A;
        this.number_B = number_B;
    }

    public BigDecimal getResult(){
        return new BigDecimal("0");
    }
}