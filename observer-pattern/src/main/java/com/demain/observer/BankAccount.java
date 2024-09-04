package com.demain.observer;

/**
 * 银行账户
 */
public class BankAccount {

    // 持有发布者对象
    private BankPublisher publisher;

    public void setPublisher(BankPublisher publisher) {
        this.publisher = publisher;
    }


    public void transfer() {
        System.out.println("发起转账");
        publisher.send();
    }
}

