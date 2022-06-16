package com.ghx.springboot.springbootsecurity.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ghx.springboot.springbootsecurity.result.CodeMsgEnum;
import com.ghx.springboot.springbootsecurity.result.Result;
import com.ghx.springboot.springbootsecurity.security.userdeatil.JWTUser;
import com.ghx.springboot.springbootsecurity.security.utils.JWTTokenUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 过滤用户请求
 */
public class JWTLoginFilter extends UsernamePasswordAuthenticationFilter {
    private static final ObjectMapper mapper = new ObjectMapper();

    public JWTLoginFilter(AuthenticationManager authenticationManager) {
        this.setAuthenticationManager(authenticationManager);
    }

    /**
     * 获取用户输入的用户名和密码
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String username = obtainUsername(request);
        String password = obtainPassword(request);

        if (username == null) {
            username = "";
        }

        if (password == null) {
            password = "";
        }

        username = username.trim();

        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(
                username, password);

        // 验证管理器进行验证
        // 之后就会去执行 com.ghx.springboot.springbootsecurity.security.CustomizedUserService.loadUserByUsername 方法
        // 之后就会执行 successfulAuthentication 和 unsuccessfulAuthentication 方法
        return this.getAuthenticationManager().authenticate(authRequest);
    }

    /**
     * 处理验证成功
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        JWTUser jwtUser = (JWTUser) authResult.getPrincipal();
        String token = JWTTokenUtil.createToken(jwtUser, false);
        Result result = Result.ok(JWTTokenUtil.TOKEN_PREFIX + token);

        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(mapper.writeValueAsString(result));
    }

    /**
     * 处理验证失败的
     */
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        Result result;
        if (failed instanceof BadCredentialsException) {
            result = Result.error(CodeMsgEnum.USER_PWD_ERROR);
        } else {
            result = Result.error(CodeMsgEnum.USER_UN_KNOWN_ERROR);
        }

        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(mapper.writeValueAsString(result));
    }
}
