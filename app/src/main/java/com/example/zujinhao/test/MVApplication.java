package com.example.zujinhao.test;

import android.app.Application;

import io.flutter.view.FlutterMain;

public class MVApplication extends Application {
    private static MVApplication instance;
    public static MVApplication  getInstance(){
        return instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        FlutterMain.Settings settings=new FlutterMain.Settings();
        settings.setLogTag("MyFlutter");
        FlutterMain.startInitialization(this,settings);
        String[] args = {"info", "data"};
        FlutterMain.ensureInitializationComplete(this,args);
        instance=this;
    }

}
