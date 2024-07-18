package com.demain.strategy.decorator;

import com.demain.strategy.decorator.decorator.ServiceChargeDecorator;
import com.demain.strategy.decorator.decorator.TaxDecorator;
import com.demain.strategy.decorator.po.Product;
import com.demain.strategy.decorator.strategy.BillingStrategy;
import com.demain.strategy.decorator.strategy.HappyHourStrategy;
import com.demain.strategy.decorator.strategy.NormalStrategy;

public class Main {
    public static void main(String[] args) {
        // 使用正常计费策略
        BillingStrategy normalStrategy = new NormalStrategy();
        Product product = new Product(100, normalStrategy);
        System.out.println("正常计费: " + product.getPrice());

        // 切换到打折计费策略
        product.setStrategy(new HappyHourStrategy());
        System.out.println("打折计费: " + product.getPrice());

        // 使用装饰器增加税费
        BillingStrategy taxStrategy = new TaxDecorator(new HappyHourStrategy());
        product.setStrategy(taxStrategy);
        System.out.println("打折加税计费: " + product.getPrice());

        // 使用装饰器增加税费和服务费
        BillingStrategy taxAndServiceStrategy = new ServiceChargeDecorator(new TaxDecorator(new HappyHourStrategy()));
        product.setStrategy(taxAndServiceStrategy);
        System.out.println("打折加税加服务费计费: " + product.getPrice());
    }
}