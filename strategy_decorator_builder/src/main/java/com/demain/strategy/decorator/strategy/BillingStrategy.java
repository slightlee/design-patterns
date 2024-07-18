package com.demain.strategy.decorator.strategy;

/**
 * 计费策略接口
 */
public interface BillingStrategy {
    double getActPrice(double rawPrice);
}