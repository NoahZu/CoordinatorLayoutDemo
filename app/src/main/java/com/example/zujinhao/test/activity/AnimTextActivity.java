package com.example.zujinhao.test.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.example.zujinhao.test.R;
import com.example.zujinhao.test.widget.ChangeEditText;

public class AnimTextActivity extends BaseActivity {

    private int current = 100;
    private TextSwitcher textSwitcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_text);
        textSwitcher = (TextSwitcher) findViewById(R.id.ts_switcher);
        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                EditText t = new EditText(AnimTextActivity.this);
                t.setBackgroundColor(Color.parseColor("#00000000"));
                t.setTextSize(40);
                return t;
            }
        });
        textSwitcher.setInAnimation(this,R.anim.slide_out_down);
        textSwitcher.setOutAnimation(this,R.anim.slide_in_up);
    }


    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_jia:
                textSwitcher.setText((++current) + "");
                break;
            case R.id.btn_jian:
                textSwitcher.setText((--current) + "");
                break;
        }
    }
}
