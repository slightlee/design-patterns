package com.demain.strategy.decorator.strategy.sx;

import com.demain.strategy.decorator.enums.SxEnum;
import com.demain.strategy.decorator.service.SxService;
import com.demain.strategy.decorator.strategy.SxStrategy;
import org.springframework.stereotype.Service;

@Service
public class S2Strategy implements SxStrategy {

    private final SxService sxService;

    public S2Strategy(SxService sxService) {
        this.sxService = sxService;
    }

    @Override
    public SxEnum type() {
        return SxEnum.S2;
    }

    @Override
    public String content() {
        return sxService.getContent();
    }
}
