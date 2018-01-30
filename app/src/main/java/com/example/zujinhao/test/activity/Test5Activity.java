package com.example.zujinhao.test.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.example.zujinhao.test.R;

public class Test5Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test5);

        findViewById(R.id.action_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(findViewById(R.id.main_content),"我是不是很可爱？n(*≧▽≦*)n",Snackbar.LENGTH_SHORT).show();
            }
        });
    }
}
