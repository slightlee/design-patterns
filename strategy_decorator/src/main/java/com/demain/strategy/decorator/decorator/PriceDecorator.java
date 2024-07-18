package com.demain.strategy.decorator.decorator;

import com.demain.strategy.decorator.strategy.BillingStrategy;

/**
 * 抽象装饰器类
 */
public abstract class PriceDecorator implements BillingStrategy {
    protected BillingStrategy strategy;

    public PriceDecorator(BillingStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public double getActPrice(double rawPrice) {
        return strategy.getActPrice(rawPrice);
    }
}