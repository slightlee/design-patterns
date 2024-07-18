package com.demain.strategy.decorator.po;

import com.demain.strategy.decorator.strategy.BillingStrategy;

/**
 * 商品类
 */
public class Product {
    private double price;

    private BillingStrategy strategy;

    public Product(double price, BillingStrategy strategy) {
        this.price = price;
        this.strategy = strategy;
    }

    public double getPrice() {
        return strategy.getActPrice(price);
    }

    public void setStrategy(BillingStrategy strategy) {
        this.strategy = strategy;
    }
}
