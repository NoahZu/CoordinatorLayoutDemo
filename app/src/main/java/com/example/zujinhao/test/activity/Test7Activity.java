package com.example.zujinhao.test.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.zujinhao.test.R;
import com.example.zujinhao.test.widget.DrawGiftView;

public class Test7Activity extends BaseActivity {
    DrawGiftView giftView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test7);
        giftView = (DrawGiftView) findViewById(R.id.draw_gift_view);
    }


    public void onClick(View view){
        switch (view.getId()){
            case R.id.btn_clear:
                giftView.clear();
                break;
        }
    }
}
