package com.example.zujinhao.test.widget;


import android.animation.Animator;
import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by zujinhao on 2017/10/30.
 */

public class ChangeEditText extends EditText{


    public ChangeEditText(Context context) {
        this(context,null);
    }

    public ChangeEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        setMaxLines(2);
        setBackgroundColor(Color.parseColor("#00000000"));
    }


    public void setTextWithAnim(final String newString){
        append("\n"+newString);
        animate().translationY(-getLineHeight()).setDuration(200).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                setTranslationY(0);
                setText(newString);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        }).start();
    }

}
