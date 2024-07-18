package com.demain.strategy.decorator.decorator;

import com.demain.strategy.decorator.strategy.BillingStrategy;

/**
 * 税费装饰器
 */
public class TaxDecorator extends PriceDecorator {
    public TaxDecorator(BillingStrategy strategy) {
        super(strategy);
    }

    @Override
    public double getActPrice(double rawPrice) {
        return super.getActPrice(rawPrice) * 1.1; // 加10%的税
    }
}