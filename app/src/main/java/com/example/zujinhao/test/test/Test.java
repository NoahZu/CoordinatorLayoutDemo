package com.example.zujinhao.test.test;

/**
 * Created by zujinhao on 2018/2/2.
 */

public class Test {

    static {
        System.loadLibrary("myNativeLib");
    }

    public static native String getString();
}
