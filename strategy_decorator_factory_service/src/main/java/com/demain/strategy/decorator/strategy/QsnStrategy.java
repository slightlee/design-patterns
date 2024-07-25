package com.demain.strategy.decorator.strategy;


/**
 * 策略接口
 */
public interface QsnStrategy extends Strategy {

    /**
     * 类型
     */
    String type();

    /**
     * 消息
     */
    String getMsg();

}
