package com.demain.strategy.decorator.c.decorator;

import com.demain.strategy.decorator.strategy.QsnStrategy;

/**
 * 策略C 装饰器实现
 */
public class CStrategyDecorator extends StrategyDecorator {

    public CStrategyDecorator(QsnStrategy strategy) {
        super(strategy);
    }

    public String getMsg2() {
        return "from C StrategyDecorator Message";
    }

}
