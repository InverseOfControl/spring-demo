package com.example.springbootdesign.demo2.annotation;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface BankAPIField {
    String type() default "";

    int length() default -1;
}
