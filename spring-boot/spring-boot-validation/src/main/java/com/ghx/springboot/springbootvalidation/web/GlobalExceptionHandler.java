package com.ghx.springboot.springbootvalidation.web;

import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public Map<String, Object> argumentValidException(BindException exception) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", "0");
        result.put("msg", exception.getFieldError().getDefaultMessage());
        return result;
    }
}
