package com.demain.strategy.decorator.annotation;

import com.demain.strategy.decorator.c.decorator.StrategyDecorator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义装饰器注解
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Decoratable {
    Class<? extends StrategyDecorator> decorator();
}
