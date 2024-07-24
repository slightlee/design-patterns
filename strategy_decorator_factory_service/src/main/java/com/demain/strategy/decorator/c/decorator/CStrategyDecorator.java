package com.demain.strategy.decorator.c.decorator;

import com.demain.strategy.decorator.service.IndexService;
import com.demain.strategy.decorator.strategy.ExtendedQsnStrategy;
import com.demain.strategy.decorator.strategy.QsnStrategy;

/**
 * 策略C 装饰器实现
 */
public class CStrategyDecorator extends StrategyDecorator implements ExtendedQsnStrategy {

    private final IndexService indexService;

    public CStrategyDecorator(QsnStrategy strategy, IndexService indexService) {
        super(strategy);
        this.indexService = indexService;
    }

    @Override
    public String getMsg2() {
//        return "from C StrategyDecorator Message";
        // 增加从service获取
        return indexService.getMsg2();
    }

}
