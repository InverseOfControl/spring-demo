package com.example.springbootdesign.demo1.web;

import com.example.springbootdesign.demo1.service.PurchaseGoods;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class Demo1Controller {

    @Resource
    private ApplicationContext context;

    @GetMapping("/demo1/{type}")
    public void demo1(@PathVariable String type) {
        PurchaseGoods purchaseGoods = (PurchaseGoods) context.getBean(type + "Person");
        purchaseGoods.calculatePrice();
    }
}
