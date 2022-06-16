package demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyProxy<T> implements InvocationHandler {
    HelloService target;

    public <T> HelloService getInstance(HelloService target) {
        this.target = target;
        Class clazz = target.getClass();
        return (HelloService) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(this.target, args);
    }
}
