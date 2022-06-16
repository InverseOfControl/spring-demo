package com.example.springbootproxy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ServiceProxy<T> implements InvocationHandler {

    private Class<T> interfaces;

    public ServiceProxy(Class<T> interfaces) {
        this.interfaces = interfaces;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getDeclaringClass().equals(interfaces)) {
            return method.getName();
        } else {
            return method.invoke(new DefaultService(), args);
        }
    }
}
