package com.ghx.springboot.springbootsecurity.security;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ghx.springboot.springbootsecurity.dao.UserRepository;
import com.ghx.springboot.springbootsecurity.entity.User;
import com.ghx.springboot.springbootsecurity.security.userdeatil.JWTUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class CustomizedUserService implements UserDetailsService {

    @Resource
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        // 查询用户
        User user = userRepository.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, s));
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }

        // 查询权限

        JWTUser jwtUser = new JWTUser(user, "");
        return jwtUser;
    }
}
