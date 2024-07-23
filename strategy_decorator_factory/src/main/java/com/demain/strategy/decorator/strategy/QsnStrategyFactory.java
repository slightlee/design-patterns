package com.demain.strategy.decorator.strategy;

import com.demain.strategy.decorator.annotation.Decoratable;
import com.demain.strategy.decorator.c.decorator.StrategyDecorator;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
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
        // 检查是否需要装饰
        Decoratable decoratable = strategy.getClass().getAnnotation(Decoratable.class);
        if (decoratable != null) {
            Class<? extends StrategyDecorator> decoratorClass = decoratable.decorator();
            try {
                Constructor<? extends StrategyDecorator> constructor = decoratorClass.getConstructor(QsnStrategy.class);
                strategy = constructor.newInstance(strategy);
            } catch (Exception e) {
                throw new RuntimeException("无法创建装饰器实例: " + decoratorClass.getName(), e);
            }
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