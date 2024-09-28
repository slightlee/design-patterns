package com.demain.observer.context;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SmsListener implements ApplicationListener<BankEvent> {
    @Override
    public void onApplicationEvent(BankEvent event) {
        System.out.println("发送短信:" + event.getSource());
    }
}
