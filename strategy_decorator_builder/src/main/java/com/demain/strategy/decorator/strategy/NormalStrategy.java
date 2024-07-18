package com.demain.strategy.decorator.strategy;

/**
 * 正常计费策略
 */
public class NormalStrategy implements BillingStrategy {
    @Override
    public double getActPrice(double rawPrice) {
        return rawPrice;
    }
}