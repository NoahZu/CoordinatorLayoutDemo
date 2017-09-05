package com.example.zujinhao.test.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import com.example.zujinhao.test.R;
import com.zhl.userguideview.UserGuideView;

public class UserGuideActivity extends Activity {
    private Button button;
    private UserGuideView userGuideView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_guide);

        button = findViewById(R.id.yap);
        userGuideView = findViewById(R.id.guideView);

        userGuideView.setHighLightView(button);

    }
}
