package com.example.zujinhao.test.aop;

import android.graphics.Paint;
import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Author: jzu
 * Date: 2018/10/29
 * Function:
 */
@Aspect
public class BaseAspect {
    private static final String TAG = "基础用法测试";


    @Before("execution(* com.example.zujinhao.test.aop.AopActivity.testBeforeAndAfter(..))")
    public void activityOnMethodBefore(JoinPoint joinPoint){
        String key = joinPoint.getSignature().toString();
        Log.d(TAG,"activityOnMethodBefore:调用方法路径"+key);
    }


    @After("execution(* com.example.zujinhao.test.aop.AopActivity.testBeforeAndAfter(..))")
    public void activityOnMethodAfter(JoinPoint joinPoint){
        String key = joinPoint.getSignature().toString();
        Log.d(TAG,"activityOnMethodAfter:调用方法路径"+key);
    }

    @Around("execution(* com.example.zujinhao.test.aop.AopActivity.testAround(..))")
    public void activityOnMethodAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String key = joinPoint.getSignature().toString();

        Log.d(TAG,"activityOnMethodFirst:调用方法路径"+key);
        joinPoint.proceed();
        Log.d(TAG,"activityOnMethodSecond:调用方法路径"+key);

    }
}
