package com.example.zujinhao.test.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.Nullable;

import com.example.zujinhao.test.ICompute;

/**
 * Created by zujinhao on 2018/3/12.
 */

public class SingleProcessServices extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }


    class MyBinder extends ICompute.Stub{

        @Override
        public int add(int a, int b) throws RemoteException {
            System.out.println("当前线程："+Thread.currentThread().getId());
            return a + b;
        }
    }
}
