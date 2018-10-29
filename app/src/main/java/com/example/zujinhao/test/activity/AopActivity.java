package com.example.zujinhao.test.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.zujinhao.test.R;

public class AopActivity extends AppCompatActivity {

    private static final String TAG = "基础用法测试";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aop);


        testBeforeAndAfter();
        testAround();
    }

    private void testBeforeAndAfter(){
        Log.d(TAG, "testBeforeAndAfter: 原本需执行的代码");
    }

    private void testAround(){
        Log.d(TAG, "testAround: 原本需执行的代码");
    }
}
