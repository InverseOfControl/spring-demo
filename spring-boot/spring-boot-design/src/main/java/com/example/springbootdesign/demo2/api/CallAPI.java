package com.example.springbootdesign.demo2.api;

import com.example.springbootdesign.demo2.annotation.BankAPI;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Arrays;

@Component
public class CallAPI {
    public static void call(AbstractAPI abstractAPI) {
        BankAPI bankAPI = abstractAPI.getClass().getAnnotation(BankAPI.class);
        Field[] fields = abstractAPI.getClass().getDeclaredFields();
        Arrays.stream(fields).forEach(field -> {
            field.setAccessible(true);

            Object value = "";
            try {
                value = field.get(abstractAPI);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            System.out.println(value);
        });
    }
}
