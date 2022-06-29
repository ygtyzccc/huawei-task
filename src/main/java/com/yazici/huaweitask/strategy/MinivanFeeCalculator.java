package com.yazici.huaweitask.strategy;

public class MinivanFeeCalculator implements FeeCalculationStrategy {

  private static final double FEE_RATE = 0.15;

  @Override
  public double calculate(Long price) {
    return price + price * FEE_RATE;
  }
}
