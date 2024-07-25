package com.demain.strategy.decorator.strategy.sx;

import com.demain.strategy.decorator.enums.SxEnum;
import com.demain.strategy.decorator.strategy.SxStrategy;
import org.springframework.stereotype.Service;

@Service
public class S1Strategy implements SxStrategy {

    @Override
    public SxEnum type() {
        return SxEnum.S1;
    }

    @Override
    public String content() {
        return "S1 内容";
    }
}
