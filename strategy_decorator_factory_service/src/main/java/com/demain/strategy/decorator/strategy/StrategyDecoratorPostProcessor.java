//package com.demain.strategy.decorator.strategy;
//
//import com.demain.strategy.decorator.annotation.Decoratable;
//import com.demain.strategy.decorator.c.decorator.StrategyDecorator;
//import com.demain.strategy.decorator.service.IndexService;
//import io.micrometer.common.lang.Nullable;
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.config.BeanPostProcessor;
//import org.springframework.context.ApplicationContext;
//import org.springframework.stereotype.Component;
//
//import java.lang.reflect.Constructor;
//
///**
// * BeanPostProcessor 允许在 Spring 容器完成初始化之后对 bean 进行进一步处理。
// */
//@Component
//public class StrategyDecoratorPostProcessor implements BeanPostProcessor {
//
//    @Autowired
//    private ApplicationContext applicationContext;
//
//    @Override
//    public Object postProcessBeforeInitialization(@Nullable Object bean,@Nullable String beanName) throws BeansException {
//        return bean;
//    }
//
//    @Override
//    public Object postProcessAfterInitialization(@Nullable Object bean,@Nullable String beanName) throws BeansException {
//        if (bean instanceof QsnStrategy) {
//            Decoratable decoratable = bean.getClass().getAnnotation(Decoratable.class);
//            if (decoratable != null) {
//                Class<? extends StrategyDecorator> decoratorClass = decoratable.decorator();
//                try {
//                    // 确保这里的构造函数参数与装饰器类的构造函数匹配
//                    Constructor<? extends StrategyDecorator> constructor = decoratorClass.getConstructor(QsnStrategy.class, IndexService.class);
//                    IndexService indexService = applicationContext.getBean(IndexService.class);
//                    StrategyDecorator decorator = constructor.newInstance(bean, indexService);
//                    // 自动注入装饰器的依赖
//                    applicationContext.getAutowireCapableBeanFactory().autowireBean(decorator);
//                    return decorator;
//                } catch (Exception e) {
//                    throw new RuntimeException("无法创建装饰器实例: " + decoratorClass.getName(), e);
//                }
//            }
//        }
//        return bean;
//    }
//}
//
