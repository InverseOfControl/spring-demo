package com.example.springbootdesign.demo2.api;

import com.example.springbootdesign.demo2.annotation.BankAPI;
import com.example.springbootdesign.demo2.annotation.BankAPIField;

@BankAPI(desc = "用户API", uri = "/user/demo")
public class UserAPI extends AbstractAPI {
    @BankAPIField(type = "String", length = 50)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
