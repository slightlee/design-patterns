package com.demain.strategy.decorator.controller;

import com.demain.strategy.decorator.enums.SxEnum;
import com.demain.strategy.decorator.strategy.ExtendedQsnStrategy;
import com.demain.strategy.decorator.strategy.QsnStrategy;
import com.demain.strategy.decorator.strategy.StrategyFactory;
import com.demain.strategy.decorator.strategy.SxStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class IndexController {

    private final StrategyFactory qsnStrategyFactory;

    @RequestMapping(value = "getMsg")
    public String getMsg() {

        String msg = qsnStrategyFactory.getStrategy("A", QsnStrategy.class).getMsg();
        String msg1 = qsnStrategyFactory.getStrategy("B", QsnStrategy.class).getMsg();
        String msg2 = qsnStrategyFactory.getStrategy("C", QsnStrategy.class).getMsg();
        System.out.println(msg + "--------" + msg1 + "-------" + msg2);

        QsnStrategy strategyC = qsnStrategyFactory.getStrategy("C", QsnStrategy.class);
        if (strategyC instanceof ExtendedQsnStrategy) {
            String msg01 = strategyC.getMsg();
            String msg02 = ((ExtendedQsnStrategy) strategyC).getMsg2();
            System.out.println("msg:" + "--------" + msg01 + "------" + msg02);
        }

        String content = qsnStrategyFactory.getStrategy(SxEnum.S1, SxStrategy.class).content();
        String content2 = qsnStrategyFactory.getStrategy(SxEnum.S2, SxStrategy.class).content();

        System.out.println("content:" + "--------" + content + "------" + content2);

        return "获取成功";
    }

}
