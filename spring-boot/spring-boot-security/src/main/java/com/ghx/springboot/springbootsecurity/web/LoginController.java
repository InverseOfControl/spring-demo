package com.ghx.springboot.springbootsecurity.web;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ghx.springboot.springbootsecurity.dao.UserRepository;
import com.ghx.springboot.springbootsecurity.entity.User;
import com.ghx.springboot.springbootsecurity.result.Result;
import com.ghx.springboot.springbootsecurity.security.userdeatil.JWTUser;
import com.ghx.springboot.springbootsecurity.security.utils.JWTTokenUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class LoginController {

    @Resource
    private UserRepository repository;

    @GetMapping("/demo")
    public Result demo() {
        return Result.ok("{\"name\":\"高宏旭\"}");
    }

    @GetMapping("/robotLogin")
    public Result robotLogin() {
        long userId = 1L;
        User user = repository.selectOne(Wrappers.<User>lambdaQuery().eq(User::getId, userId));
        JWTUser jwtUser = new JWTUser(user, "");
        String token = JWTTokenUtil.createToken(jwtUser, false);
        return Result.ok(JWTTokenUtil.TOKEN_PREFIX + token);
    }
}
