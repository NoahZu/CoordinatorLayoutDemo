package com.example.zujinhao.test.activity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.zujinhao.test.R;

public class RotateActivity extends BaseActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotate);

        imageView = (ImageView) findViewById(R.id.image);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.animate().rotationY(180).setDuration(1000).start();
            }
        });

    }
}
