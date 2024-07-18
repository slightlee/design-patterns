package com.demain.strategy.decorator.builder;

import com.demain.strategy.decorator.decorator.ServiceChargeDecorator;
import com.demain.strategy.decorator.decorator.TaxDecorator;
import com.demain.strategy.decorator.strategy.BillingStrategy;

public class BillingStrategyBuilder {
    private BillingStrategy strategy;

    public BillingStrategyBuilder(BillingStrategy initialStrategy) {
        this.strategy = initialStrategy;
    }

    public BillingStrategyBuilder addTax() {
        this.strategy = new TaxDecorator(this.strategy);
        return this;
    }

    public BillingStrategyBuilder addServiceCharge() {
        this.strategy = new ServiceChargeDecorator(this.strategy);
        return this;
    }

    public BillingStrategy build() {
        return this.strategy;
    }
}
