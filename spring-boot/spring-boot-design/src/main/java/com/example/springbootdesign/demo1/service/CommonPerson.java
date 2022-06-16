package com.example.springbootdesign.demo1.service;

import org.springframework.stereotype.Service;

@Service
public class CommonPerson extends PurchaseGoods {
    @Override
    public void calculatePrice() {
        System.out.println(10);
    }
}
