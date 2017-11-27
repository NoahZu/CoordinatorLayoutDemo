package com.example.zujinhao.test.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.zujinhao.test.R;
import com.example.zujinhao.test.utils.UIUtil;
import com.example.zujinhao.test.widget.RadioFlexboxLayout;
import com.google.android.flexbox.FlexboxLayout;

public class RadioFlexboxLayoutActivity extends Activity {

    private RadioFlexboxLayout radioFlexboxLayout;
    private Button addBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_flexbox_layout);

        radioFlexboxLayout = (RadioFlexboxLayout) findViewById(R.id.radio_flex_box);
        addBtn = (Button) findViewById(R.id.btn_add);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radioFlexboxLayout.addView(getRadioBtn());
            }
        });


    }

    private View getRadioBtn() {
        RadioButton radioButton = new RadioButton(this);
        FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, UIUtil.dip2px(this,30));
        radioButton.setLayoutParams(layoutParams);
        radioButton.setBackgroundResource(R.drawable.bg_coupon);
        radioButton.setTextColor(Color.BLACK);
        radioButton.setText("优惠券");
        radioButton.setPadding(UIUtil.dip2px(this,12),0,UIUtil.dip2px(this,12),0);
        radioButton.setTextSize(TypedValue.COMPLEX_UNIT_SP,13);
        return radioButton;
    }
}
