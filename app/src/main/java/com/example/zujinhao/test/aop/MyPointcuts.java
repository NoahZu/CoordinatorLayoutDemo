package com.example.zujinhao.test.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author: jzu
 * Date: 2018/10/31
 * Function:
 */

@Retention(RetentionPolicy.CLASS)//声明注解类
@Target({ElementType.CONSTRUCTOR,ElementType.METHOD})//作用于构造方法和方法
public @interface MyPointcuts {

}
