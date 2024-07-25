package com.demain.strategy.decorator.service;

import org.springframework.stereotype.Service;

@Service
public class SxService {

    public String getContent() {
        return "from S2 content and service";
    }
}
