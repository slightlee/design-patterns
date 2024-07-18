package com.demain.strategy.decorator.decorator;

import com.demain.strategy.decorator.strategy.BillingStrategy;

/**
 * 服务费装饰器
 */
public class ServiceChargeDecorator extends PriceDecorator {
    public ServiceChargeDecorator(BillingStrategy strategy) {
        super(strategy);
    }

    @Override
    public double getActPrice(double rawPrice) {
        return super.getActPrice(rawPrice) + 5.0; // 加5元服务费
    }
}