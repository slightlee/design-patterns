package com.demain.strategy.decorator.c.decorator;

import com.demain.strategy.decorator.strategy.QsnStrategy;

/**
 * 装饰器基类
 */
public abstract class StrategyDecorator implements QsnStrategy {

    protected final QsnStrategy strategy;

    protected StrategyDecorator(QsnStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public String type() {
        return strategy.type();
    }

    @Override
    public String getMsg() {
        return strategy.getMsg();
    }
}
