package com.demain.observer;

import com.demain.observer.context.AppListener;
import com.demain.observer.context.SmsListener;
import com.demain.observer.service.BankAccountService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 测试1
 */
public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
        BankAccountService bankAccountService = applicationContext.getBean(BankAccountService.class);
        bankAccountService.transfer();
    }


    static class MyConfig {
        @Bean
        public BankAccountService bankAccountService() {
            return new BankAccountService();
        }

        @Bean
        public SmsListener smsListener() {
            return new SmsListener();
        }

        @Bean
        public AppListener appListener() {
            return new AppListener();
        }
    }
}
