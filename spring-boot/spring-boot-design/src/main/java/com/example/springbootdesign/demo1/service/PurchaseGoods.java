package com.example.springbootdesign.demo1.service;

public abstract class PurchaseGoods {

    public void purchase() {
        System.out.println("公共方法");
    }

    public abstract void calculatePrice();
}
