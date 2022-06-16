package com.ghx.springboot.springbootsecurity.security.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ghx.springboot.springbootsecurity.result.CodeMsgEnum;
import com.ghx.springboot.springbootsecurity.result.Result;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomizedAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        Result result = Result.error(CodeMsgEnum.USER_NOT_LOGIN);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(objectMapper.writeValueAsString(result));
    }

}
