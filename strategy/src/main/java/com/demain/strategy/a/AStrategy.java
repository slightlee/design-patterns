package com.demain.strategy.a;

import com.demain.strategy.enums.QsnEnum;
import com.demain.strategy.strategys.QsnStrategy;
import org.springframework.stereotype.Service;

@Service
public class AStrategy implements QsnStrategy {
    @Override
    public String type() {
        return QsnEnum.A.toString();
    }

    @Override
    public String getMsg() {
        return "数据A";
    }
}
