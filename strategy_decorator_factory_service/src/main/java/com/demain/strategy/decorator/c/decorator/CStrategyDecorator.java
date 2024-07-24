package com.demain.strategy.decorator.c.decorator;

import com.demain.strategy.decorator.strategy.ExtendedQsnStrategy;
import com.demain.strategy.decorator.strategy.QsnStrategy;

/**
 * 策略C 装饰器实现
 */
public class CStrategyDecorator extends StrategyDecorator implements ExtendedQsnStrategy {


    public CStrategyDecorator(QsnStrategy strategy) {
        super(strategy);
    }

    @Override
    public String getMsg2() {
        return "from C StrategyDecorator Message";
    }

}
