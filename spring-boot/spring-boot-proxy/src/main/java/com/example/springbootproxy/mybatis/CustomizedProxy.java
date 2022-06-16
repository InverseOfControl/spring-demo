package com.example.springbootproxy.mybatis;

import org.springframework.web.client.RestTemplate;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CustomizedProxy<T> implements InvocationHandler {

    private final RestTemplate restTemplate = new RestTemplate();

    private final Class<T> interfaces;

    public CustomizedProxy(Class<T> interfaces) {
        this.interfaces = interfaces;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(CustomizedRequestMapping.class)) {
            CustomizedRequestMapping requestMapping = method.getAnnotation(CustomizedRequestMapping.class);
            String requestUrl = requestMapping.url();
            /*Object obj = restTemplate.getForObject(requestUrl, String.class, (Object) null);*/
            return requestUrl;
        }

        return method.getName();
    }
}
