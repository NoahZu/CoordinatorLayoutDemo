package com.example.zujinhao.test.activity;

import android.graphics.drawable.LevelListDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.zujinhao.test.R;

public class DrawableTestActivity extends AppCompatActivity {
    private ImageView imageView;
    private Button levelAddBtn;
    private LevelListDrawable levelListDrawable;
    private int currentLevel = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable_test);

        imageView = (ImageView) findViewById(R.id.iv_level);
        levelAddBtn = (Button) findViewById(R.id.btn_add);
        levelListDrawable = (LevelListDrawable) imageView.getDrawable();

        levelAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentLevel > 7){
                    currentLevel = 1;
                }
                levelListDrawable.setLevel(currentLevel++);
            }
        });
    }
}
