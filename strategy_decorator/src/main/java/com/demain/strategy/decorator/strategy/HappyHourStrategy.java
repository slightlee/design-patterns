package com.demain.strategy.decorator.strategy;

/**
 * 打折计费策略
 */
public class HappyHourStrategy implements BillingStrategy {
    @Override
    public double getActPrice(double rawPrice) {
        return rawPrice * 0.8;
    }
}