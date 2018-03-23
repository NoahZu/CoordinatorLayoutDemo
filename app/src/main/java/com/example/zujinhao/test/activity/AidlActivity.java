package com.example.zujinhao.test.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.zujinhao.test.ICompute;
import com.example.zujinhao.test.R;
import com.example.zujinhao.test.other.UIToast;
import com.example.zujinhao.test.service.SingleProcessServices;

public class AidlActivity extends AppCompatActivity {
    private ICompute iCompute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aidl);

        bindService();
    }


    public void onClick(View view) {
        System.out.println("主线程："+Thread.currentThread().getId());
        try {
            int result = iCompute.add(9,10);
            UIToast.show(AidlActivity.this,"结果是:"+result);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private void bindService() {
        Intent intent = new Intent(AidlActivity.this, SingleProcessServices.class);
        bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                iCompute = ICompute.Stub.asInterface(service);
                UIToast.show(AidlActivity.this,"绑定成功");
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                UIToast.show(AidlActivity.this,"解除绑定");
                iCompute = null;
            }
        },BIND_AUTO_CREATE);
    }
}
