package com.demain.strategy.decorator.strategy;


/**
 * 策略接口
 */
public interface QsnStrategy extends Strategy<String> {

    /**
     * 消息
     */
    String getMsg();

}
