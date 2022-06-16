package com.example.springbootdesign.demo2.api;

import com.example.springbootdesign.demo2.annotation.BankAPI;
import com.example.springbootdesign.demo2.annotation.BankAPIField;

@BankAPI(desc = "支付API", uri = "/pay/demo")
public class PayAPI extends AbstractAPI {
    @BankAPIField(type = "String", length = 10)
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
