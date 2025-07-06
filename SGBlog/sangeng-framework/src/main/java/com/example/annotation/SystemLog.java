package com.example.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//原注解
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
//自定义注解
public @interface SystemLog {
    String businessName();
}
