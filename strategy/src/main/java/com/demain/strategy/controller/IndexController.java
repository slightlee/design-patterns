package com.demain.strategy.controller;

import com.demain.strategy.strategys.QsnStrategyFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class IndexController {

    private final QsnStrategyFactory qsnStrategyFactory;

    @RequestMapping(value = "getMsg")
    public String getMsg() {
        String msgA = qsnStrategyFactory.getStrategy("A").getMsg();
        String msgB = qsnStrategyFactory.getStrategy("B").getMsg();
        System.out.println(msgA + "----" + msgB);
        return "数据获取成功";
    }
}
