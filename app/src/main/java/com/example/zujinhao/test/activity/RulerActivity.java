package com.example.zujinhao.test.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.zujinhao.test.R;
import com.example.zujinhao.test.widget.RulerView;

public class RulerActivity extends BaseActivity {
    private RulerView rulerView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ruler);
        rulerView = (RulerView) findViewById(R.id.rv_view);
    }

    public void onClick(View view){
        if (view.getId() == R.id.btn_add){
//            rulerView.left(1);
        }
    }
}
