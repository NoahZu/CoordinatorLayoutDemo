package com.example.zujinhao.test;

import android.app.Application;


public class MVApplication extends Application {
    private static MVApplication instance;
    public static MVApplication  getInstance(){
        return instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
    }

}
