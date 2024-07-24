package com.demain.strategy.decorator.aspect;

import com.demain.strategy.decorator.annotation.Decoratable;
import com.demain.strategy.decorator.c.decorator.StrategyDecorator;
import com.demain.strategy.decorator.service.IndexService;
import com.demain.strategy.decorator.strategy.QsnStrategy;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;

@Aspect
@Component
public class StrategyDecoratorAspect {

    @Autowired
    private ApplicationContext applicationContext;

    @Pointcut("execution(* com.demain.strategy.decorator.strategy.QsnStrategyFactory.getStrategy(..))")
    public void getStrategyPointcut() {}

    @Around("getStrategyPointcut()")
    public Object aroundGetStrategy(ProceedingJoinPoint joinPoint) throws Throwable {
        QsnStrategy strategy = (QsnStrategy) joinPoint.proceed();
        Decoratable decoratable = strategy.getClass().getAnnotation(Decoratable.class);
        if (decoratable != null) {
            Class<? extends StrategyDecorator> decoratorClass = decoratable.decorator();
            try {
                Constructor<? extends StrategyDecorator> constructor = decoratorClass.getConstructor(QsnStrategy.class, IndexService.class);
                IndexService indexService = applicationContext.getBean(IndexService.class);
                StrategyDecorator decorator = constructor.newInstance(strategy, indexService);
                applicationContext.getAutowireCapableBeanFactory().autowireBean(decorator);
                return decorator;
            } catch (NoSuchMethodException e) {
                throw new RuntimeException("无法找到适当的构造函数: " + decoratorClass.getName(), e);
            } catch (Exception e) {
                throw new RuntimeException("无法创建装饰器实例: " + decoratorClass.getName(), e);
            }
        }
        return strategy;
    }
}
