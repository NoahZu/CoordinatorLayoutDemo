package com.example.zujinhao.test.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.zujinhao.test.R;

public class LiveRoomActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_room);
    }


    public void onClick(View view){
        if (view.getId() == R.id.btn_test){
            Toast.makeText(LiveRoomActivity.this,"测试。。。。。。",Toast.LENGTH_LONG).show();
        }
    }
}
