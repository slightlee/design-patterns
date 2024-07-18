package com.demain.strategy.b;

import com.demain.strategy.enums.QsnEnum;
import com.demain.strategy.strategys.QsnStrategy;
import org.springframework.stereotype.Service;

@Service
public class BStrategy implements QsnStrategy {
    @Override
    public String type() {
        return QsnEnum.B.toString();
    }

    @Override
    public String getMsg() {
        return "数据B";
    }
}
