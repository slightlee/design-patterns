package com.demain.observer.service;

import com.demain.observer.context.BankEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAccountService {

    // 注入事件发布器
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    public void transfer() {
        System.out.println("发起转账");
        // 参数是需要传递给订阅者的信息
        applicationEventPublisher.publishEvent(new BankEvent("转账"));
    }
}
