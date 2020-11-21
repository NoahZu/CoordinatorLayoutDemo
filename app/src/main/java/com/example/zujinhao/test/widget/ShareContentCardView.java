package com.example.zujinhao.test.widget;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import com.example.zujinhao.test.R;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by zujinhao on 2018/1/12.
 */

public class ShareContentCardView extends FrameLayout {
    SimpleDraweeView simpleDraweeView;
    public ShareContentCardView(@NonNull Context context) {
        this(context,null);
    }

    public ShareContentCardView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,-1);
    }

    public ShareContentCardView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);


        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_answer_live_share_generator,this);
        simpleDraweeView = (SimpleDraweeView) findViewById(R.id.iv_avatar);
    }


    public void setData(){
        simpleDraweeView.setImageURI("http://q.qlogo.cn/qqapp/1104915773/C74AAAA54EF7FEF372F5C595E98DD70E/100");
    }
}
