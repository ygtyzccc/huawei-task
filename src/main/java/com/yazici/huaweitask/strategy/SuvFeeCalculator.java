package com.yazici.huaweitask.strategy;

public class SuvFeeCalculator implements FeeCalculationStrategy{

    private static final double FEE_RATE = 0.10;

    @Override
    public double calculate(Long price) {
        return price + price * FEE_RATE;
    }
}
