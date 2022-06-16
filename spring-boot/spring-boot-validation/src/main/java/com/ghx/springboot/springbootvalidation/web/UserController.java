package com.ghx.springboot.springbootvalidation.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @GetMapping("/user/list")
    public Map<String, Object> userList(@Valid User user) {
        Map<String, Object> map = new HashMap<>();
        return map;
    }

}
