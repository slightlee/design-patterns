package com.demain.observer;

public class Test {

    public static void main(String[] args) {

        // 创建被观察者
        BankAccount bankAccount = new BankAccount();
        // 创建观察者
        SmsSender smsSender = new SmsSender();
        AppSender appSender = new AppSender();
        //创建发布者
        BankPublisher publisher = new BankPublisher();
        publisher.addSender(smsSender);
        publisher.addSender(appSender);
        //被观察者绑定publish
        bankAccount.setPublisher(publisher);
        //改变被观察者的状态
        bankAccount.transfer();
    }

}
