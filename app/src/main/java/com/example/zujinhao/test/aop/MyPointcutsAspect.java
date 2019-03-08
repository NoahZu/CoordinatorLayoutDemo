package com.example.zujinhao.test.aop;

import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Author: jzu
 * Date: 2018/10/31
 * Function:
 */

@Aspect
public class MyPointcutsAspect {
    private static final String MY_POINTCUTS_TAG = "自定义切点用法测试";

    @Pointcut("execution(@com.example.zujinhao.test.aop.MyPointcuts * *(..))")
    public void myPointcutsMethod() {

    }
    @Around("myPointcutsMethod()")
    public void onMyPointcutsMethodAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String key = proceedingJoinPoint.getSignature().toString();
        Log.d(MY_POINTCUTS_TAG, "方法调用之前插入: " + key);
        proceedingJoinPoint.proceed();
        Log.d(MY_POINTCUTS_TAG, "方法调用之后插入: " + key);
    }

}
