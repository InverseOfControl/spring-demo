package com.example.springbootdesign.demo2.web;

import com.example.springbootdesign.demo2.api.AbstractAPI;
import com.example.springbootdesign.demo2.api.CallAPI;
import com.example.springbootdesign.demo2.api.PayAPI;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo2Controller {

    @GetMapping("/demo2")
    public void demo2() {
        PayAPI payAPI = new PayAPI();
        payAPI.setUserId("111");
        CallAPI.call(payAPI);
    }
}
