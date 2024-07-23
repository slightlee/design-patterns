package com.demain.strategy.decorator.c;

import com.demain.strategy.decorator.annotation.Decoratable;
import com.demain.strategy.decorator.c.decorator.CStrategyDecorator;
import com.demain.strategy.decorator.enums.QsnEnum;
import com.demain.strategy.decorator.strategy.QsnStrategy;
import org.springframework.stereotype.Service;

/**
 * 策略C
 */
@Decoratable(decorator = CStrategyDecorator.class)
@Service
public class CStrategy implements QsnStrategy {
    @Override
    public String type() {
        return QsnEnum.C.toString();
    }

    @Override
    public String getMsg() {
        return "from C msg";
    }
}
