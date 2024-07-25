package com.demain.strategy.decorator.strategy;


import com.demain.strategy.decorator.enums.SxEnum;

/**
 * 策略接口 2
 */
public interface SxStrategy extends Strategy<SxEnum> {

    /**
     * 内容
     */
    String content();

}
