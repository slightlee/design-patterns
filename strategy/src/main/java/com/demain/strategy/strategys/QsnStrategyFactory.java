package com.demain.strategy.strategys;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 策略类简单工厂
 */
@Component
public class QsnStrategyFactory implements InitializingBean, ApplicationContextAware {

    private static final Map<String, QsnStrategy> STRATEGY_MAP = new HashMap<>();

    private ApplicationContext applicationContext;

    /**
     * 根据类型获取对应的处理器
     *
     * @param type 类型
     * @return 类型对应的处理器
     */
    public QsnStrategy getStrategy(String type) {
        return STRATEGY_MAP.get(type);
    }

    @Override
    public void afterPropertiesSet() {
        applicationContext.getBeansOfType(QsnStrategy.class).values().forEach(
                handler -> STRATEGY_MAP.put(handler.type(), handler)
        );
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
