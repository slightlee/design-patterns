package com.demain.strategy.decorator.strategy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class StrategyFactory implements InitializingBean, ApplicationContextAware {

    private static final Map<Object, Strategy<?>> STRATEGY_MAP = new ConcurrentHashMap<>();

    private ApplicationContext applicationContext;

    public <T extends Strategy<?>> T getStrategy(Object type, Class<T> strategyType) {
        Strategy<?> strategy = STRATEGY_MAP.get(type);
        if (strategy == null) {
            throw new IllegalArgumentException("没有找到类型为 " + type + " 的策略处理器");
        }
        if (!strategyType.isInstance(strategy)) {
            throw new IllegalArgumentException("策略类型不匹配");
        }
        return strategyType.cast(strategy);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        applicationContext.getBeansOfType(Strategy.class).values().forEach(
                handler -> STRATEGY_MAP.put(handler.type(), handler)
        );
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
