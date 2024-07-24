package com.demain.strategy.decorator.controller;

import com.demain.strategy.decorator.strategy.ExtendedQsnStrategy;
import com.demain.strategy.decorator.strategy.QsnStrategy;
import com.demain.strategy.decorator.strategy.QsnStrategyFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class IndexController {

    private final QsnStrategyFactory qsnStrategyFactory;

    @RequestMapping(value = "getMsg")
    public String getMsg() {

        String msg = qsnStrategyFactory.getStrategy("A").getMsg();
        String msg1 = qsnStrategyFactory.getStrategy("B").getMsg();
        String msg2 = qsnStrategyFactory.getStrategy("C").getMsg();
        System.out.println(msg + "--------" + msg1 + "-------" + msg2);

        QsnStrategy strategyC = qsnStrategyFactory.getStrategy("C");
        if (strategyC instanceof ExtendedQsnStrategy) {
            String msg01 = strategyC.getMsg();
            String msg02 = ((ExtendedQsnStrategy) strategyC).getMsg2();
            System.out.println("msg:" + "--------" + msg01 + "------" + msg02);
        }
        return "获取成功";
    }
}
