package com.demain.strategy.decorator.a;

import com.demain.strategy.decorator.enums.QsnEnum;
import com.demain.strategy.decorator.strategy.QsnStrategy;
import org.springframework.stereotype.Service;

@Service
public class AStrategy implements QsnStrategy {
    @Override
    public String type() {
        return QsnEnum.A.toString();
    }

    @Override
    public String getMsg() {
        return "from A msg";
    }
}
