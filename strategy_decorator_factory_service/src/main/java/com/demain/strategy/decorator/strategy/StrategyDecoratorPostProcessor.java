package com.demain.strategy.decorator.strategy;

import com.demain.strategy.decorator.annotation.Decoratable;
import com.demain.strategy.decorator.c.decorator.StrategyDecorator;
import io.micrometer.common.lang.Nullable;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;

/**
 * BeanPostProcessor 允许在 Spring 容器完成初始化之后对 bean 进行进一步处理。
 */
@Component
public class StrategyDecoratorPostProcessor implements BeanPostProcessor {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public Object postProcessBeforeInitialization(@Nullable Object bean, @Nullable String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(@Nullable Object bean, @Nullable String beanName) throws BeansException {
        if (bean instanceof QsnStrategy) {
            return processQsnStrategy((QsnStrategy) bean);
        }
        return bean;
    }

    private Object processQsnStrategy(QsnStrategy strategy) {
        Decoratable decoratable = strategy.getClass().getAnnotation(Decoratable.class);
        if (decoratable != null) {
            Class<? extends StrategyDecorator> decoratorClass = decoratable.decorator();
            try {
                return createDecorator(strategy, decoratorClass);
            } catch (Exception e) {
                throw new RuntimeException("无法创建装饰器实例: " + decoratorClass.getName(), e);
            }
        }
        return strategy;
    }

    private StrategyDecorator createDecorator(QsnStrategy strategy, Class<? extends StrategyDecorator> decoratorClass) throws Exception {
        Constructor<?>[] constructors = decoratorClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            if (isSuitableConstructor(constructor)) {
                Object[] args = resolveConstructorArguments(constructor.getParameterTypes(), strategy);
                StrategyDecorator decorator = (StrategyDecorator) constructor.newInstance(args);
                applicationContext.getAutowireCapableBeanFactory().autowireBean(decorator);
                return decorator;
            }
        }
        throw new RuntimeException("没有找到合适的构造函数: " + decoratorClass.getName());
    }

    private boolean isSuitableConstructor(Constructor<?> constructor) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        boolean hasStrategy = false;
        for (Class<?> paramType : parameterTypes) {
            if (QsnStrategy.class.isAssignableFrom(paramType)) {
                hasStrategy = true;
            } else {
                try {
                    applicationContext.getBean(paramType);
                } catch (BeansException e) {
                    return false; // 如果bean不存在则不适用此构造函数
                }
            }
        }
        return hasStrategy;
    }

    private Object[] resolveConstructorArguments(Class<?>[] parameterTypes, QsnStrategy strategy) {
        Object[] args = new Object[parameterTypes.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            if (QsnStrategy.class.isAssignableFrom(parameterTypes[i])) {
                args[i] = strategy;
            } else {
                args[i] = applicationContext.getBean(parameterTypes[i]);
            }
        }
        return args;
    }
}

