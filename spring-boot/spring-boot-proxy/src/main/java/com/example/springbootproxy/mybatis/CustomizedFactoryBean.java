package com.example.springbootproxy.mybatis;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

public class CustomizedFactoryBean implements FactoryBean {

    private final Class interfaces;

    public CustomizedFactoryBean(Class interfaces) {
        this.interfaces = interfaces;
    }

    @Override
    public Object getObject() throws Exception {
        return Proxy.newProxyInstance(interfaces.getClassLoader(), new Class[]{interfaces},
                new CustomizedProxy<>(interfaces));
    }

    @Override
    public Class<?> getObjectType() {
        return interfaces;
    }
}
