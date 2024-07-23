package com.demain.strategy.decorator.strategy;

import com.demain.strategy.decorator.c.decorator.CStrategyDecorator;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class QsnStrategyFactory implements InitializingBean, ApplicationContextAware {

    private static final Map<String, QsnStrategy> STRATEGY_MAP = new ConcurrentHashMap<>();

    private ApplicationContext applicationContext;

    public QsnStrategy getStrategy(String type) {
        QsnStrategy strategy = STRATEGY_MAP.get(type);
        if (strategy == null) {
            throw new IllegalArgumentException("没有找到类型为 " + type + " 的策略处理器");
        }
        // 如果是C类型的策略，则使用装饰者模式
        if ("C".equals(type)) {
            strategy = new CStrategyDecorator(strategy);
        }
        return strategy;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        applicationContext.getBeansOfType(QsnStrategy.class).values().forEach(
                handler -> STRATEGY_MAP.put(handler.type(), handler)
        );
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}