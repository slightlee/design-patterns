package com.demain.strategy.decorator.b;

import com.demain.strategy.decorator.enums.QsnEnum;
import com.demain.strategy.decorator.strategy.QsnStrategy;
import org.springframework.stereotype.Service;

@Service
public class BStrategy implements QsnStrategy {
    @Override
    public String type() {
        return QsnEnum.B.toString();
    }

    @Override
    public String getMsg() {
        return "from B msg";
    }
}
