package com.example.springbootproxy.proxy;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.Proxy;

/**
 * 代理类工厂
 *
 * @author 高宏旭
 * @date 2022/4/25 0025 10:13
 */
public class ServiceProxyFactoryBean<T> implements FactoryBean<T> {

    private Class<T> interfaces;

    public ServiceProxyFactoryBean(Class<T> interfaces) {
        this.interfaces = interfaces;
    }

    @Override
    public T getObject() throws Exception {
        return (T) Proxy.newProxyInstance(interfaces.getClassLoader(), new Class[]{interfaces},
                new ServiceProxy<>(interfaces));
    }

    @Override
    public Class<?> getObjectType() {
        return interfaces;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
