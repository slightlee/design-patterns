package com.demain.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 发布者
 */
public class BankPublisher {

    // 持有多个sender对象
    private final List<Sender> senders = new ArrayList<>();

    public void addSender(Sender sender) {
        this.senders.add(sender);
    }

    // 通知所有的观察者
    public void send() {
        for (Sender sender : this.senders) {
            sender.send();
        }
    }
}
