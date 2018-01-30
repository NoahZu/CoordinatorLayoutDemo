package com.example.zujinhao.test.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.zujinhao.test.R;
import com.example.zujinhao.test.service.FloatingWindowService;

public class FloatingViewActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floating_view);
    }

    public void onClick(View view){
        switch (view.getId()){
            case R.id.show_floating:
                Intent show = new Intent(this, FloatingWindowService.class);
                show.putExtra(FloatingWindowService.OPERATION, FloatingWindowService.OPERATION_SHOW);
                startService(show);
                break;
            case R.id.close_floating:
                Intent hide = new Intent(this, FloatingWindowService.class);
                hide.putExtra(FloatingWindowService.OPERATION, FloatingWindowService.OPERATION_HIDE);
                startService(hide);
                break;
        }
    }

}

