package com.demain.observer.context;

import org.springframework.context.ApplicationEvent;

public class BankEvent extends ApplicationEvent {

    public BankEvent(Object source) {
        super(source);
    }
}
