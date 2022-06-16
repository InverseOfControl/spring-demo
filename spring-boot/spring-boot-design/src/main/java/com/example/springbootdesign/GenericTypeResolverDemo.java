package com.example.springbootdesign;

import org.springframework.core.GenericTypeResolver;

import java.lang.reflect.Method;

public class GenericTypeResolverDemo {
    public static void main(String[] args) throws NoSuchMethodException {
        Method method = GenericTypeResolverDemo.class.getMethod("getString", Object.class);
        Class<?> returnType = GenericTypeResolver.resolveReturnType(method, GenericTypeResolverDemo.class);
        System.out.println(returnType);

    }

    public static <T> String getString(T aaa) {
        return null;
    }
}
