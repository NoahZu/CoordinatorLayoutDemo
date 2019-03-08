package com.example.zujinhao.test.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.zujinhao.test.R;

public class DrawLayoutActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_layout);


        findViewById(R.id.redView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DrawLayoutActivity.this,"我被点击啦啦啦啦啦",Toast.LENGTH_LONG).show();
            }
        });
    }
}
