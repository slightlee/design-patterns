package com.demain.strategy.decorator.service;

import org.springframework.stereotype.Service;

@Service
public class IndexService {

    public String getMsg2(){
        return "from C StrategyDecorator Message and service";
    }
}
