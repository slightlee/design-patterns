package com.demain.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 银行账户
 */
public class BankAccount {

    // 持有多个sender对象
    private final List<Sender> senders = new ArrayList<>();

    public void addSender(Sender sender) {
        this.senders.add(sender);
    }

    // 通知所有的观察者
    private void send() {
        for (Sender sender : this.senders) {
            sender.send();
        }
    }

    public void transfer() {
        System.out.println("发起转账");
        send();
    }
}

