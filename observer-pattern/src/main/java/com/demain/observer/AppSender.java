package com.demain.observer;

/**
 * 发送app信息
 */
public class AppSender implements Sender {
    @Override
    public void send() {
        System.out.println("发送app信息");
    }
}
