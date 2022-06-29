package com.yazici.huaweitask.strategy;

public class SedanFeeCalculator implements FeeCalculationStrategy{

    private static final double FEE_RATE = 0;

    @Override
    public double calculate(Long price)
    {
        return price + price * FEE_RATE;
    }
}
