package com.example.zujinhao.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Test7Activity extends AppCompatActivity {
    DrawGiftView giftView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test7);
        giftView = (DrawGiftView) findViewById(R.id.draw_gift_view);
    }


    public void onClick(View view){
        giftView.clear();
    }
}
