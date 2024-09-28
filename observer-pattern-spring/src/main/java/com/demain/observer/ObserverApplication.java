package com.demain.observer;

import com.demain.observer.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ObserverApplication {

    @Autowired
    private BankAccountService accountService;
    public static void main(String[] args) {
        SpringApplication.run(ObserverApplication.class, args);
    }

    /**
     * 测试2
     */
    @RequestMapping("/transfer")
    public String transfer() {
        accountService.transfer();
        return "发送成功";
    }
}
